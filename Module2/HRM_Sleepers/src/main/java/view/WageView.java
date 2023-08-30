package view;


import model.WageRange;
import service.TimeService;
import service.WageService;
import utils.DateUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static utils.DateUtils.parseDate;


public class WageView {
    private WageService wageService = new WageService();
    private Scanner scanner = new Scanner(System.in);
    private final String fileTime = "./data/timekeeping.txt";
//    private static final int DEFAULT_WAGE = 0;

    private Map<String, Integer> wageMap;


    public WageView() {
        wageMap = new HashMap<>();
        wageMap.put("StaffServe", 15000);
        wageMap.put("ServingFood", 16000);
        wageMap.put("Receptionist", 20000);
        wageMap.put("RegionalChief", 25000);
        wageMap.put("Manager", 35000);
    }

    public int getBasicWageFromFile() {
        String staffId = enterStaffId();
        String jobTitle = wageService.getJobTitleFromStaffFile(staffId);
        return getWageByJobTitle(jobTitle);
    }

    private int getWageByJobTitle(String jobTitle) {
        for (Map.Entry<String, Integer> entry : wageMap.entrySet()) {
            String key = entry.getKey();
            if (jobTitle.equalsIgnoreCase(key)) {
                return entry.getValue();
            }
        }
        return 0;
    }

    public String enterStaffId() {
        System.out.print("Nhập ID nhân viên: ");
        return scanner.nextLine();
    }

    public int BasicWage() {
        int basiWage = getBasicWageFromFile();
        return basiWage;
    }

    public double Wage() {
        String staffId = enterStaffId();
        String jobTitle = wageService.getJobTitleFromStaffFile(staffId);
        int basicWage = getWageByJobTitle(jobTitle);
        TimeService timeService = new TimeService();
        double wage = timeService.calculateSalary(fileTime, staffId, basicWage);

        // Lưu thông tin lương vào file wage.txt
        LocalDate date =LocalDate.now() ;
        wageService.saveWageToFile(staffId,timeService.totalTime(fileTime, staffId).toHours(), wage,DateUtils.formatDate(date));

        return wage;
    }
    public void showWage() {
        List<WageRange>wage=wageService.getAllWage();
        for(WageRange w:wage){
            System.out.println(w.toString());
        }
    }



    public static void main(String[] args) {
        WageView wageView = new WageView();
       wageView.showWage();
    }

}
