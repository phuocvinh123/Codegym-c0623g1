package service;

import model.AdminModel;
import model.TimeModel;
import utils.FileUtils;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static utils.FileUtils.readData;
import static utils.FileUtils.writeData;

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
                    System.out.println("Lỗi khi ghi thông tin chấm công vào tệp tin.");
                }
                System.out.println("Check In thành công!");
                checkedInStaffId = staffId; // Lưu trữ mã nhân viên đã Check In thành công
                break;
            }
        }
        if (!foundStaffId) {
            System.out.println("Mã nhân viên không tồn tại. Vui lòng nhập lại.");
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
                System.out.println("Lỗi: " + e.getMessage());
            }
        } else {
            System.out.println("Giờ check-out không được để trống. Vui lòng nhập lại.");
        }
    }
    public Duration totalTime(String fileTime,String staffId) {
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

            // In thông tin về thời gian làm việc của các ngày có cùng ID
            System.out.println("Tổng thời gian làm việc của ID " + staffId + ": " + totalWorkTime.toHours() + "H, " + totalWorkTime.toMinutesPart() + " p");

        } catch (IOException e) {
            System.out.println("Lỗi khi đọc tệp tin.");
        }

        return totalWorkTime;
    }

    }


