package view;

import service.AdminService;
import service.IAminService;
import service.TimeService;

import java.util.Scanner;

public class StaffView {
    private IAminService iStaffService;
    private Scanner scanner = new Scanner(System.in);

    public StaffView() {
        iStaffService = new AdminService();
    }
    public void launcher(){
        boolean checkAction = false;
        while (true) {
            System.out.println("                                                           ╔════════════════════════════════════════════╗");
            System.out.println("                                                           ║       Trang thông tin nhân viên            ║");
            System.out.println("                                                           ║      1. Xem thông tin nhân viên            ║");
            System.out.println("                                                           ║      2. Chấm công                          ║");
            System.out.println("                                                           ║      3. Hiển thị tổng số thời gian làm việc║");
            System.out.println("                                                           ║     trong 1 tháng                          ║");
            System.out.println("                                                           ║      4. Tính lương                         ║");
            System.out.println("                                                           ║      5.Hiển thị tổng giờ làm               ║");
            System.out.println("                                                           ║      0. Quay lại                           ║");
            System.out.println("                                                           ╚════════════════════════════════════════════╝");
            int actionMenu = Integer.parseInt(scanner.nextLine());
            switch (actionMenu) {
                case 0->{
                    menu();
                }
                case 1 -> {
                    showStaff();
                }
                case 2 -> {
                    showStaff();
                    Timekeeping();
                }
                case 3 -> {
                    hoursWorked();
                }
                case 4 -> {
                    Payroll();
                }
                case 5 -> {
                    showTiem();
                }
//                case 6 -> {
//                    sortStaff();
//                }
//                default -> {
//                }
            }
        }
    }

    private void showTiem() {
        TimeView timeView=new TimeView();
        timeView.totalTime();
    }

    private void Payroll() {
        WageView wageView=new WageView();
        wageView.Wage();
    }

    private void hoursWorked() {
        TimeView timeView = new TimeView();
        timeView.totalTime();
    }

    private void Timekeeping() {
        TimeView timeView=new TimeView();
        timeView.launcher();
    }

    private void showStaff() {
    AdminView adminView=new AdminView();
    adminView.showStaff();
    }

    private void menu() {
        LoginView loginView=new LoginView();
        loginView.menu();
    }

    public static void main(String[] args) {
        StaffView staffView=new StaffView();
        staffView.launcher();
    }
}


