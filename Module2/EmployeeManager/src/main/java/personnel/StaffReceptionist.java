package personnel;

import java.time.LocalDate;
import java.util.Scanner;

public class StaffReceptionist extends Staff{
    public StaffReceptionist(String fullName, String cccd, String address, String phone, String email, String position, String gender, int age, LocalDate birthday, double workingHours, double wage, double basicSalary, Scanner scanner) {
        super(fullName, cccd, address, phone, email, position, gender, age, birthday, workingHours, wage, basicSalary, scanner);
    }

    public StaffReceptionist() {
    }

    @Override
    public double Payroll() {
        return super.Payroll();
    }
}
