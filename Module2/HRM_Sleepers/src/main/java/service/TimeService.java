package service;

import model.AdminModel;
import model.TimeModel;
import utils.FileUtils;

import java.io.FileWriter;
import java.io.IOException;
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

    private final Scanner scanner = new Scanner(System.in);

    public List<AdminModel> getAllAdmin() {
        return FileUtils.readData(fileStaff, AdminModel.class);
    }

    public void checkIn() {
        System.out.println("Check In - Nhập thông tin:");
        String staffId = "";
        boolean foundStaffId = false;
        while (!foundStaffId) {
            System.out.print("Mã nhân viên: ");
            staffId = scanner.nextLine();
            LocalDateTime currentTime = LocalDateTime.now();
            String formattedTime = currentTime.format(formatter);
            List<AdminModel> adminList = readData(fileStaff, AdminModel.class);
            for (AdminModel admin : adminList) {
                if (String.valueOf(admin.getId()).equals(staffId)) {
                    foundStaffId = true;
                    List<String> newData = new ArrayList<>();
                    newData.add(staffId + "," + formattedTime + ",");
                    writeData(fileTime, newData);
                    System.out.println("Check In thành công!");
                    checkedInStaffId = staffId; // Lưu trữ mã nhân viên đã Check In thành công
                    break;
                }
            }
            if (!foundStaffId) {
                System.out.println("Mã nhân viên không tồn tại. Vui lòng nhập lại.");
            }
        }
    }

    public void checkOut() {
        System.out.println("Check Out - Nhập thông tin:");
        if (checkedInStaffId.isEmpty()) {
            System.out.println("Không có nhân viên đã Check In.");
            return;
        }
        String checkOutTime = "";
        boolean validCheckOutTime = false;
        while (!validCheckOutTime) {
            System.out.print("Giờ check-out (HH:mm:ss): ");
            checkOutTime = scanner.nextLine();
            if (!checkOutTime.isEmpty()) {
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
    }
    public void totalTime() {
        String staffId = enterStaffId(); // Yêu cầu người dùng nhập ID nhân viên
        List<TimeModel> checkInData = readData(fileTime,TimeModel.class); // Đọc dữ liệu check-in và check-out từ file
        if (checkInData.size() < 4) {
            System.out.println("Nhân viên có mã id: " + staffId + " chưa có đủ thông tin check-in và check-out.");
            return;
        }
        long totalWorkingMinutes = 0;

        for (int i = 2; i < checkInData.size(); i++) {
            TimeModel timeModel = checkInData.get(i);
            String checkInTimeString = timeModel.getStartTime();
            String checkOutTimeString = timeModel.getEndTime();


            Date checkInTime = (Date) formatter.parse(checkInTimeString);
            Date checkOutTime = (Date) formatter.parse(checkOutTimeString);
            long durationInMillis = checkOutTime.getTime() - checkInTime.getTime();
            totalWorkingMinutes += durationInMillis / (1000 * 60); // Chuyển đổi sang phút và cộng vào tổng thời gian
        }
        long totalWorkingHours = totalWorkingMinutes / 60;
        long remainingMinutes = totalWorkingMinutes % 60;

        System.out.println("Thời gian làm việc của nhân viên với id: " + staffId + " là: " + totalWorkingHours + " giờ " + remainingMinutes + " phút");


    }

    public String enterStaffId() {
        System.out.print("Nhập ID nhân viên: ");
        return scanner.nextLine();
    }



}
