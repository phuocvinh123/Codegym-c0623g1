package bai13;

import java.time.LocalDate;
import java.util.List;

public class Fresher extends Employee{
    private LocalDate graduationDate;
    private String graduationRank;
    private String education;

    public Fresher(String l, String longDang, LocalDate graduationDate, String graduationRank, String education, int i, List<Certificate> certificatesFresher, LocalDate localDate, String kha, String truongBachKhoa) {
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.education = education;
    }

    public Fresher(String id, String fullName, LocalDate birthDay, String phone, String email, int employeeType, LocalDate graduationDate, String graduationRank, String education) {
        super(id, fullName, birthDay, phone, email, employeeType);
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.education = education;
    }

    public LocalDate getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(LocalDate graduationDate) {
        this.graduationDate = graduationDate;
    }

    public String getGraduationRank() {
        return graduationRank;
    }

    public void setGraduationRank(String graduationRank) {
        this.graduationRank = graduationRank;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @Override
    public String toString() {
        return "Fresher: " +
                ", id=" + id +
                ", fullName='" + fullName + '\'' +
                ", birthDay=" + birthDay +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", employeeType=" + employeeType +
                ", graduationDate=" + graduationDate +
                ", graduationRank='" + graduationRank + '\'' +
                ", education='" + education + '\''  ;
    }
}
