package personnel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import model.IParseModel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Staff  {
    public String fullName,cccd,address,phone,email,position,gender;
    public int age;
    public LocalDate birthday;
    public double workingHours;
    public double wage,basicSalary;

    Scanner scanner=new Scanner(System.in);
    public String getPosition() {
        String strType = "";
        if (position != null) {
            switch (position) {
                case "0":
                    strType = "Staff Serve";
                    break;
                case "1":
                    strType = "Staff Serving Food";
                    break;
                case "2":
                    strType = "Staff receptionist";
                    break;
                case "3":
                    strType = "regional chief";
                    break;
                case "4":
                    strType = "manage";
                    break;
            }
        }
        return strType;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getGender() {
        String str = "";
        if (gender != null) {
            switch (gender) {
                case "0":
                    str = "male";
                    break;
                case "1":
                    str = "femail";
                    break;
                case "2":
                    str = "other";
                    break;
            }
        }
        return str;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    public double getWage() {
       int wageAmount = 0; // Khai báo và khởi tạo biến wageAmount
        // Xác định và gán giá trị cho biến wage

        // Sử dụng switch-case với kiểu dữ liệu phù hợp
        switch ((int) wage) {
            case 0:
                wageAmount = 15000;
                break;
            case 1:
                wageAmount = 16000;
                break;
            case 2:
                wageAmount = 20000;
                break;
            case 3:
                wageAmount = 25000;
                break;
            case 4:
                wageAmount = 35000;
                break;
        }
        return wageAmount;
    }
    public double Payroll(){
        this.basicSalary=this.wage*this.workingHours;
        return this.basicSalary;
    }

        public void showInfor(){
            System.out.println("                                                              Staff information(Thông tin Nhân viên):");
            System.out.println("=================================================================================================================================================================================================================================");
            System.out.printf(" %15s |%15s |%15s |%15s |%15s |%15s |%15s |%30s |%30s |%15s |%20s \n","Position","FullName","Age","Gender","Birthday","CCCD","Phone number","Address","Email","Working Hours","Wage");
            System.out.printf(" %15s |%15s |%15s |%15s |%15s |%15s |%15s |%30s |%30s |%15s |%20s \n",this.getPosition(),this.getFullName(),this.getAge(),this.getGender(),this.getBirthday(),this.getCccd(),this.getPhone(),this.getAddress(),this.getEmail(),this.getWorkingHours(),this.getWage());
            System.out.println("=================================================================================================================================================================================================================================");
        }
    public static void input(Staff serve){
        serve.setPosition(GetValue.getPosition("Nhập chức vụ"));
        serve.setFullName(GetValue.getFullName("Nhập tên"));
        serve.setAge(GetValue.getAge("Nhập tuổi"));
        serve.setGender(GetValue.getGender("Nhập 0->2 male,female,other"));
        serve.setCccd(GetValue.getCccd("Nhập số cccd"));
        serve.setAddress(GetValue.getAddress("Nhập địa chỉ"));
        serve.setBirthday(GetValue.getBirtDay("Nhập ngày sinh"));
        serve.setPhone(GetValue.getPhone("Nhập số điện thoại"));
        serve.setEmail(GetValue.getEmail("Nhập Email"));
        serve.setWorkingHours(GetValue.getWorking("Nhập số giờ làm việc"));
        serve.setWage(GetValue.getWage("nhập 0->4 để nhận lương tương ứng"));
    }


}
