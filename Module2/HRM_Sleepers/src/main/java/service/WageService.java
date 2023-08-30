package service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WageService {
    private final String fileStaff = "./data/staff.txt";
    private final String fileTime = "./data/timekeeping.txt";
    private final String fileWage = "./data/wage.txt";
    private Map<String, Integer> wageMap;

    public Map<String, Integer> readStaffFile() {
        try {
            File staffFile = new File(fileStaff);
            Scanner staffScanner = new Scanner(staffFile);
            Map<String, Integer> staffWageMap = new HashMap<>();

            while (staffScanner.hasNextLine()) {
                String line = staffScanner.nextLine();
                String[] data = line.split(",");
                if (data.length >= 2) {
                    String staffId = data[0].trim();
                    String jobTitle = data[1].trim();
                    staffWageMap.put(staffId, wageMap.getOrDefault(jobTitle, 0));
                }
            }

            staffScanner.close();
            return staffWageMap;
        } catch (FileNotFoundException e) {
            System.out.println("Staff file not found: " + e.getMessage());
            return null;
        }
    }

    public Map<String, Integer> readTimekeepingFile() {
        try {
            File timeFile = new File(fileTime);
            Scanner timeScanner = new Scanner(timeFile);
            Map<String, Integer> timekeepingMap = new HashMap<>();

            while (timeScanner.hasNextLine()) {
                String line = timeScanner.nextLine();
                String[] data = line.split(",");
                if (data.length >= 2) {
                    String staffId = data[0].trim();
                    int hoursWorked = Integer.parseInt(data[1].trim());
                    timekeepingMap.put(staffId, hoursWorked);
                }
            }

            timeScanner.close();
            return timekeepingMap;
        } catch (FileNotFoundException e) {
            System.out.println("Timekeeping file not found: " + e.getMessage());
            return null;
        }
    }

    public void writeWageFile(double totalWage) {
        try {
            File wageFile = new File(fileWage);
            FileWriter writer = new FileWriter(wageFile);
            writer.write("Total wage: " + totalWage);
            writer.close();
            System.out.println("Wage file written successfully.");
        } catch (IOException e) {
            System.out.println("Error writing wage file: " + e.getMessage());
        }
    }

}
