package view;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class WageView {
    private static final int DEFAULT_WAGE = 0;

    private Map<String, Integer> wageMap;

    public WageView() {
        wageMap = new HashMap<>();
        wageMap.put("StaffServe", 15000);
        wageMap.put("StaffServingFood", 16000);
        wageMap.put("StaffReceptionist", 20000);
        wageMap.put("RegionalChief", 25000);
        wageMap.put("Manager", 35000);
    }

    public double calculateTotalWage(Map<String, Integer> staffWageMap, Map<String, Integer> timekeepingMap) {
        double totalWage = 0;

        for (Map.Entry<String, Integer> entry : timekeepingMap.entrySet()) {
            String staffId = entry.getKey();
            int hoursWorked = entry.getValue();
            int wage = staffWageMap.getOrDefault(staffId, DEFAULT_WAGE);
            totalWage += wage * hoursWorked;
        }

        return totalWage;
    }


}
