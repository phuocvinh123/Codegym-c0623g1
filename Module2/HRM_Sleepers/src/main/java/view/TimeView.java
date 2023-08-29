package view;

import service.IAminService;
import service.TimeService;

import java.util.Scanner;

public class TimeView {
    private Scanner scanner = new Scanner(System.in);

    public void launcher() {
        boolean checkAction = false;
        while (true) {
            System.out.println("                                                           ╔════════════════════════════════════════════╗");
            System.out.println("                                                           ║       Nỗ lực hết mình trong công việc,     ║");
            System.out.println("                                                           ║  luôn tươi cười, thân thiên với khách hàng ║");
            System.out.println("                                                           ║      1.Check In (bắt đầu làm việc thôi nào ║");
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
                default -> {continue;}
            }
        }
    }

    private void menu() {
    }

    public void checkOut1(){
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
                default -> {continue;}
            }
        }
    }


    private void checkIn() {
        AdminView adminView=new AdminView();
        adminView.showStaff();
        TimeService timeService=new TimeService();
        timeService.checkIn();
        checkOut1();
    }

    private void checkOut() {
        TimeService timeService=new TimeService();
        timeService.checkOut();
        StaffView staffView=new StaffView();
        staffView.launcher();
    }


}
