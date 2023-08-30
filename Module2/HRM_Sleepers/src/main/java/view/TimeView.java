package view;

import model.AdminModel;
import service.IAminService;
import service.TimeService;

import java.io.*;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import static utils.FileUtils.readData;

public class TimeView {
    private Scanner scanner = new Scanner(System.in);

    private static String checkedInStaffId = "";
    TimeService timeService = new TimeService();

    public void launcher() {
        boolean checkAction = false;
        while (true) {
            System.out.println("                                                           ╔════════════════════════════════════════════╗");
            System.out.println("                                                           ║       Nỗ lực hết mình trong công việc,     ║");
            System.out.println("                                                           ║  luôn tươi cười, thân thiên với khách hàng ║");
            System.out.println("                                                           ║      1.Check In (bắt đầu làm việc thôi nào)║");
            System.out.println("                                                           ║      0. Quay lại                           ║");
            System.out.println("                                                           ╚════════════════════════════════════════════╝");
            int actionMenu = Integer.parseInt(scanner.nextLine());
            switch (actionMenu) {
                case 0 -> {
                    menu();
                }
                case 1 -> {
                    checkIn();
                }
                default -> {
                    continue;
                }
            }
        }
    }

    private void menu() {
    }

    public void checkOut1() {
        boolean checkAction = false;
        while (true) {
            System.out.println("                                                           ╔════════════════════════════════════════════╗");
            System.out.println("                                                           ║    Bạn đã nỗ lực hết mình trong công việc, ║");
            System.out.println("                                                           ║   check out để kết thúc 1 ngày làm việc nào║");
            System.out.println("                                                           ║                1.Check Out                 ║");
            System.out.println("                                                           ║                0. Quay lại                 ║");
            System.out.println("                                                           ╚════════════════════════════════════════════╝");
            int actionMenu = Integer.parseInt(scanner.nextLine());
            switch (actionMenu) {
                case 0 -> {
                    menu();
                }
                case 1 -> {
                    checkOut();
                }
                default -> {
                    continue;
                }
            }
        }
    }


    public void checkIn() {
        AdminView adminView = new AdminView();
        adminView.showStaff();
        System.out.println("Check In - Nhập thông tin:");
        String staffId = "";
        System.out.print("Mã nhân viên: ");
        staffId = scanner.nextLine();
        checkedInStaffId = timeService.checkIntTime(staffId);
        checkOut1();
    }


    public void checkOut() {
        System.out.println("Check Out - Nhập thông tin:");
        if (checkedInStaffId.isEmpty()) {
            System.out.println("Không có nhân viên đã Check In.");
            return;
        }
        String checkOutTime = "";
        System.out.print("Giờ check-out (HH:mm:ss): ");
        checkOutTime = scanner.nextLine();
        timeService.checkOutTime(checkOutTime);
        StaffView staffView = new StaffView();
        staffView.launcher();
    }
    public void overtime() {
        double overtimeWage;
        LocalDate date = LocalDate.now(); // Lấy ngày hiện tại

        DayOfWeek dayOfWeek = date.getDayOfWeek();

        if (dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY) {
            overtimeWage = 70.0; // Mức lương tăng ca cuối tuần
        } else {
            overtimeWage = 50.0; // Mức lương tăng ca ngày thường
        }

        // Tiếp tục xử lý đăng ký tăng ca với mức lương overtimeWage
        checkOvertime(overtimeWage);
    }
    private void checkOvertime(double overtimeWage) {
        // Xử lý đăng ký tăng ca với mức lương overtimeWage
        // ...
    }

    public void totalTime() {
        String staffId = enterStaffId(); // Yêu cầu người dùng nhập ID nhân viên
        timeService.totalTime("./data/timekeeping.txt", staffId);
    }

    public String enterStaffId() {
        System.out.print("Nhập ID nhân viên: ");
        return scanner.nextLine();
    }


}