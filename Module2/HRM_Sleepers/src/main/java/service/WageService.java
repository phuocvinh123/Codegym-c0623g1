package service;

import model.AdminModel;
import model.WageRange;
import utils.FileUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class WageService {
    private final String fileStaff = "./data/staff.txt";
    private final String fileWage = "./data/wage.txt";


    public List<WageRange> getAllWage() {
        return FileUtils.readData(fileWage, WageRange.class);
    }
    public String getJobTitleFromStaffFile(String staffId) {
        String jobTitle = null;
        try (BufferedReader br = new BufferedReader(new FileReader(fileStaff))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 3) {
                    String id = data[0].trim();
                    if (id.equals(staffId)) {
                        jobTitle = data[1].trim();
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jobTitle;
    }
    public void saveWageToFile(String staffId, double workHours, double wage, String date) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(fileWage));

            boolean found = false;
            for (int i = 0; i < lines.size(); i++) {
                String line = lines.get(i);
                String[] data = line.split(",");
                if (data.length >= 4 && data[0].trim().equals(staffId)) {
                    lines.set(i, staffId + "," + workHours + "," + wage + "," + date);
                    found = true;
                    break;
                }
            }

            if (!found) {
                String newLine = staffId + "," + workHours + "," + wage + "," + date;
                lines.add(newLine);
            }
            Files.write(Paths.get(fileWage), lines);
        } catch (IOException e) {
            System.err.println("Lỗi khi ghi dữ liệu lương vào tệp tin.");
        }
    }



}
