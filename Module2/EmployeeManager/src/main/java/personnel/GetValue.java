package personnel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class GetValue extends Staff{
    static Scanner scanner = new Scanner(System.in);
    public static String getFullName(String name) {
        boolean check = false;
        do {
            System.out.println("Enter to full name:");
            name = scanner.nextLine();
            try {
                if (name.length() < 6 || name.length() > 20) {
                    throw new IllegalArgumentException(" Name must be between 6 and 20 characters long (Tên phải có độ dài từ 6 đến 20 ký tự).");
                }
                check = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Lỗi: " + e.getMessage());
            }
        } while (!check);
        return name;
    }
    public static String getGender(String gender){
       boolean check = false;
        do{System.out.println("Enter 0->2 to male,female,other");
          gender=scanner.nextLine();
            try{
                if (!(gender.equals("0") || gender.equals("1") || gender.equals("2") )) {
                    throw new IllegalArgumentException("Invalid input number. Please re-enter.(0-2)");
                }
                check=true;

            }catch (IllegalArgumentException e){
                System.out.println("Lỗi: "+e.getMessage());
            }
        }while (!check);
return gender;
    }
    public static String getPosition(String position){
       boolean check = false;
        do{System.out.println("Enter to position 0-4:");
             position=scanner.nextLine();
            try{
                if (!(position.equals("0") || position.equals("1") || position.equals("2") || position.equals("3") || position.equals("4"))) {
                    throw new IllegalArgumentException("Invalid input number. Please re-enter.(0-4)");
                }
                check=true;

            }catch (IllegalArgumentException e){
                System.out.println("Lỗi: "+e.getMessage());
            }
        }while (!check);
        return position;
    }

    public static String getCccd(String cccd){
       boolean check = false;
        do{System.out.println("Enter to cccd:");
             cccd=scanner.nextLine();
            try{
                if(cccd.length()!=12){
                    throw new IllegalArgumentException("cccd must be 12 numbers");
                }
                check=true;

            }catch (IllegalArgumentException e){
                System.out.println("Lỗi: "+e.getMessage());
            }
        }while (!check);
        return cccd;
    }
    public static String getAddress(String address){
        boolean check=false;
        do {
            System.out.println("Enter to address:");
            address = scanner.nextLine();
            try {
                if (address.length() < 10 || address.length() > 50) {
                    throw new IllegalArgumentException(" address must be between 10 and 50 characters long (địa chỉ phải có độ dài từ 10 đến 50 ký tự).");
                }
                check = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Lỗi: " + e.getMessage());
            }
        }while (!check);
        return address;
    }
    public static String getPhone(String phone){
       boolean check = false;
        do{ System.out.println("Enter to phone number:");
             phone=scanner.nextLine();
            try {
                if(!phone.matches("(09|03|05|07|08|02)\\d{8}")&&phone.length()!=10){
                    throw new IllegalArgumentException("phone number must start tape 02,03,05,07,08,09 and enough 10 numbers");
                }check=true;
            }catch (IllegalArgumentException e){
                System.out.println("Lỗi: "+e.getMessage());
            }
        }while (!check);
        return phone;
    }
    public static String getEmail(String email){
       boolean check = false;
        do{ System.out.println("Enter to email:");
             email=scanner.nextLine();
            try {
                if(!email.matches("^[A-Za-z0-9+-._]+@gmail.com+$")){
                    throw new IllegalArgumentException("Invalid email");
                }check=true;
            }catch (IllegalArgumentException e){
                System.out.println("Lỗi: "+e.getMessage());
            }
        }while (!check);
        return email;
    }
    public static int getAge(String age) {
        boolean check = false;
        int userAge = 0;

        do {
            System.out.println("Enter your age:");
            try {
                userAge =Integer.parseInt(scanner.nextLine());
                if (userAge < 18) {
                    throw new IllegalArgumentException("You are not old enough.");
                }
                check = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid age.");
                scanner.nextLine(); // Clear the input buffer
            }
        } while (!check);

        return userAge;
    }
    public static LocalDate getBirtDay(String birtDay){
        boolean check = false;
        LocalDate birthday = null;

        do {
            System.out.println("Enter your Year of Birth (dd-MM-yyyy):");
            String strDate = scanner.nextLine();

            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                birthday = LocalDate.parse(strDate, formatter);
                if (isNotOldEnough(birthday)) {
                    throw new IllegalArgumentException("You are not old enough.");
                }
                check = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (!check);

        return birthday;
    }

    public static boolean isNotOldEnough(LocalDate birthday) {
        LocalDate currentDate = LocalDate.now();
        int age = currentDate.getYear() - birthday.getYear();
        return age < 18;
    }

    public static double getWorking(String workString){
        System.out.println("Enter to working hours");
        double work=scanner.nextDouble();
        return work;
    }
    public static double getWage(String wageString){
        boolean check = false;
        double wage = 0;

        do {
            System.out.println("Enter a number between 0 and 4:");
            try {
                wage = scanner.nextDouble();
                scanner.nextLine();
                if (!(wage >= 0 && wage <= 4)) {
                    throw new IllegalArgumentException("Invalid number entered. Please re-enter. (0-4)");
                }
                check = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Clear the input buffer
            }
        } while (!check);
        return wage;
    }


    }


