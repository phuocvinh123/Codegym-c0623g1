package view;

import model.ERole;
import model.RegisterModel;
import service.IRegisterService;
import utils.DateUtils;
import utils.FileUtils;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class RegisterView implements IRegisterService {
    private final String fileLogin = "./data/login.txt";
    private Scanner scanner = new Scanner(System.in);

    @Override
    public List<RegisterModel> getAllRegister() {
        return FileUtils.readData(fileLogin, RegisterModel.class);
    }

    public void register() {
        System.out.println("Đăng ký mới người dùng:");
        String username = enterUsername();
        String password = enterPassword();
        ERole role= ERole.valueOf(enterErole());
        LocalDate birthday=enterBirtDay();
        String phone=enterPhone();
        String email=enterEmail();

        // Tạo người dùng mới
        RegisterModel registerModel = new RegisterModel(username, password,role,birthday,phone,email);
       boolean exists=usernameExists(username);
       if(exists){
           System.out.println("Tên người dùng đã tồn tại!");
       }else {
           // Lưu thông tin người dùng vào cơ sở dữ liệu hoặc tệp tin
           saveUser(registerModel);

           System.out.println("Đăng ký thành công!");
       }
    }

private String enterErole() {
    boolean check = false;
    String role = "USER";
    String adminId = "151002";

    do {
        try {
            System.out.print("Enter role (ADMIN/USER): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("ADMIN")) {
                System.out.print("Enter ADMIN ID: ");
                adminId = scanner.nextLine();
                if (adminId.equals("151002")) {
                    role = "ADMIN";
                    check = true;
                }
            } else {
                role = "USER";
                check = true;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    } while (!check);

    return role;
}



    private String enterUsername() {
        boolean check = false;
        String username;
        do {
            System.out.println("Enter the username:");
            username = scanner.nextLine();
            try {
                if (username.length() < 6 || username.length() > 20) {
                    throw new IllegalArgumentException("The username must be between 6 and 20 characters long.");
                }
                check = true;
            } catch (IllegalArgumentException e) {
                System.err.println("Error: " + e.getMessage());
            }
        } while (!check);
        return username;
    }
    public String enterEmail(){
        boolean check = false;
        String email;
        do{ System.out.println("Enter to email:");
            email=scanner.nextLine();
            try {
                if(!email.matches("^[A-Za-z0-9+-._]+@gmail.com+$")){
                    throw new IllegalArgumentException("Invalid email");
                }check=true;
            }catch (IllegalArgumentException e){
                System.err.println("Lỗi: "+e.getMessage());
            }
        }while (!check);
        return email;
    }
    public LocalDate enterBirtDay(){
        LocalDate dob = null;
        try{
            System.err.println("Nhập ngày sinh: (dd-MM-yyyy)");
            dob = DateUtils.parseDate(scanner.nextLine());
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return dob;
    }
    public String enterPhone(){
        boolean check = false;
        String phone;
        do{ System.out.println("Enter to phone number:");
            phone=scanner.nextLine();
            try {
                if(!phone.matches("(09|03|05|07|08|02)\\d{8}")&&phone.length()!=10){
                    throw new IllegalArgumentException("phone number must start tape 02,03,05,07,08,09 and enough 10 numbers");
                }check=true;
            }catch (IllegalArgumentException e){
                System.err.println("Lỗi: "+e.getMessage());
            }
        }while (!check);
        return phone;
    }
    private String enterPassword() {
        boolean check = false;
        String password;
        do {
            System.out.println("Enter the password:");
            password = scanner.nextLine();
            try {
                if (password.length() < 8 || !password.matches(".*[a-zA-Z]+.*") || !password.matches(".*\\d+.*")) {
                    throw new IllegalArgumentException("The password must be at least 8 characters long and contain at least one letter and one number.");
                }
                check = true;
            } catch (IllegalArgumentException e) {
                System.err.println("Error: " + e.getMessage());
            }
        } while (!check);
        return password;
    }

    private boolean usernameExists(String username) {
        List<RegisterModel> registerList = getAllRegister();
        for (RegisterModel register : registerList) {
            if (register.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    private void saveUser(RegisterModel registerModel) {
        List<RegisterModel> registerList = getAllRegister();
        registerList.add(registerModel);
        FileUtils.writeData(fileLogin, registerList);
    }
}
