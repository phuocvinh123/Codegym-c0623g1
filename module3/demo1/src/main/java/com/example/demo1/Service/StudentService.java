package com.example.demo1.Service;

import com.example.demo1.model.EGender;
import com.example.demo1.model.Student;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentService {
    private static final List<Student>students;
    private static int idCurrent;
    static {
        students=new ArrayList<>();
        students.add(new Student(++idCurrent, "Thang", Date.valueOf(LocalDate.now()), EGender.MALE));
        students.add(new Student(++idCurrent, "Duc", Date.valueOf(LocalDate.now()), EGender.MALE));
        students.add(new Student(++idCurrent, "Huy", Date.valueOf(LocalDate.now()), EGender.MALE));
    }
    public List<Student> getStudents(boolean deleted){
        return students.stream().filter(student -> student.isDeleted()==deleted).collect(Collectors.toList());
    }
    public void addStudent(String name, String dob, String gender){
        Student student = new Student(++idCurrent,name, Date.valueOf(dob), EGender.valueOf(gender));
        students.add(student);
    }
    public void editStudent(int id, String name,String dob, String gender){
        students.stream().filter(student -> student.getId()==id).collect(Collectors.toList())
                .forEach(student -> {
                    student.setName(name);
                    student.setDob(Date.valueOf(dob));
                    student.setGender(EGender.valueOf(gender));
                });
    }
    public void remove(int id) {
        Student deleteStudent = getStudentById(id);
        if (deleteStudent != null) {
            deleteStudent.setDeleted(true);
        }
    }
    public void restore(int id){
        Student deleteStudent = getStudentById(id);
        if (deleteStudent != null) {
            deleteStudent.setDeleted(false);
        }
    }
    public Student getStudentById(int id) {
        return students.stream().filter(student -> student.getId()==id).findFirst().orElse(null);
    }

}
