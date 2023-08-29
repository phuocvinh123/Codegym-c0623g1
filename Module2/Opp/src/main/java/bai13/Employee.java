package bai13;


import java.time.LocalDate;
import java.util.List;

public class Employee {
    protected String id;
    protected String fullName;
    protected LocalDate birthDay;
    protected String phone;
    protected String email;
    protected int employeeType;
    public static int employeeCount;

    private List<Certificate> certificates;

    public List<Certificate> getCertificates() {
        return certificates;
    }

    public void setCertificates(List<Certificate> certificates) {
        this.certificates = certificates;
    }

    public Employee() {
    }
    static {
        employeeCount = 0;
    }
    public void showInfo(){
        System.out.printf("%10s | %20s | %20s | %10s | %30s | %10s \n", this.getId(), this.getFullName(),
                this.getBirthDay(), this.getPhone(), this.getEmail(),this.getEmployeeType());
    }


    public Employee(String id, String fullName, LocalDate birthDay, String phone, String email, int employeeType) {
        this.id = id;
        this.fullName = fullName;
        this.birthDay = birthDay;
        this.phone = phone;
        this.email = email;
        this.employeeType = employeeType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(int employeeType) {
        this.employeeType = employeeType;
    }

    public static int getEmployeeCount() {
        return employeeCount;
    }

    public static void setEmployeeCount(int employeeCount) {
        Employee.employeeCount = employeeCount;
    }

    @Override
    public String toString() {
        return "Employee: " +
                " id= '" + id + '\'' +
                ", fullName= '" + fullName + '\'' +
                ", birthDay= " + birthDay +
                ", phone= '" + phone + '\'' +
                ", email= '" + email + '\'' +
                ", employeeType= " + employeeType +
                ", certificates= " + certificates ;
    }
}
