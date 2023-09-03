package service;

import model.AdminModel;

import java.io.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static utils.FileUtils.readData;

public class TimeService {
    private final String fileTime = "./data/timekeeping.txt";
    private final String fileStaff = "./data/staff.txt";

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy,HH:mm:ss");
    private static String checkedInStaffId = "";
    public String checkIntTime(String staffId ){
        boolean foundStaffId = false;
        LocalDateTime currentTime = LocalDateTime.now();
        String formattedTime = currentTime.format(formatter);
        List<AdminModel> adminList = readData(fileStaff, AdminModel.class);
        for (AdminModel admin : adminList) {
            if (String.valueOf(admin.getId()).equals(staffId)) {
                foundStaffId = true;
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileTime, true))) {
                    writer.write(staffId + "," + formattedTime + ",");
                } catch (IOException e) {
                    System.err.println("Lỗi khi ghi thông tin chấm công vào tệp tin.");
                }
                System.out.println("Check In thành công!");
                checkedInStaffId = staffId; // Lưu trữ mã nhân viên đã Check In thành công
                break;
            }
        }
        if (!foundStaffId) {
            System.err.println("Mã nhân viên không tồn tại. Vui lòng nhập lại.");
        }
        return  checkedInStaffId;
    }
    public void checkOutTime(String checkOutTime ){
        if (!checkOutTime.isEmpty()) {
            boolean validCheckOutTime = false;
            validCheckOutTime = true;
            try {
                FileWriter fileWriter = new FileWriter(fileTime, true);
                fileWriter.write(  checkOutTime + "\n");
                fileWriter.close();
                System.out.println("Check Out thành công!");
            } catch (IOException e) {
                System.err.println("Lỗi: " + e.getMessage());
            }
        } else {
            System.err.println("Giờ check-out không được để trống. Vui lòng nhập lại.");
        }
    }
    public Duration totalTime(String fileTime, String staffId) {
        Duration totalWorkTime = Duration.ZERO;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileTime))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(",");
                if (tokens.length >= 4) {
                    String id = tokens[0];
                    String checkInDate = tokens[1];
                    String checkInTimeStr = tokens[2];
                    String checkOutTimeStr = tokens[3];
                    LocalDateTime checkInDateTime = LocalDateTime.parse(checkInDate + "," + checkInTimeStr, formatter);
                    LocalDateTime checkOutDateTime = LocalDateTime.parse(checkInDate + "," + checkOutTimeStr, formatter);
                    if (id.equals(staffId)) {
                        Duration workDuration = Duration.between(checkInDateTime, checkOutDateTime);
                        totalWorkTime = totalWorkTime.plus(workDuration);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Lỗi khi đọc tệp tin.");
        }
        return totalWorkTime;
    }
    public Duration showPrintTotalWorkTime(String fileTime, String staffId) {
        Duration totalWorkTime = totalTime(fileTime, staffId);
        System.out.println("Tổng thời gian làm việc của ID " + staffId + ": " + totalWorkTime.toHours() + "H, " + totalWorkTime.toMinutesPart() + " p");
        return totalWorkTime;
    }
    public Duration printTotalWorkTime(String fileTime, String staffId) {
        Duration totalWorkTime = totalTime(fileTime, staffId);
        return totalWorkTime;
    }


    public Duration calculateTotalWorkTime(String fileTime, String staffId) {
        Duration totalWorkTime = Duration.ZERO;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileTime))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(",");
                if (tokens.length >= 4) {
                    String id = tokens[0];
                    String checkInDate = tokens[1];
                    String checkInTimeStr = tokens[2];
                    String checkOutTimeStr = tokens[3];
                    LocalDateTime checkInDateTime = LocalDateTime.parse(checkInDate + "," + checkInTimeStr, formatter);
                    LocalDateTime checkOutDateTime = LocalDateTime.parse(checkInDate + "," + checkOutTimeStr, formatter);
                    if (id.equals(staffId)) {
                        Duration workDuration = Duration.between(checkInDateTime, checkOutDateTime);
                        totalWorkTime = totalWorkTime.plus(workDuration);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Lỗi khi đọc tệp tin.");
        }

        return totalWorkTime;
    }



    }


