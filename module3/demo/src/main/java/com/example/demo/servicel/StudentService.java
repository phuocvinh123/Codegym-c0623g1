package com.example.demo.servicel;

import com.example.demo.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private static final List<Student>students;
    private static int idS;
    static {
        students= new ArrayList<>();
        students.add(new Student(++idS,"vinh",21));
        students.add(new Student(++idS,"truong",21));
        students.add(new Student(++idS,"dat",21));
    }
    public List<Student> getStudent(){
        return students;
    }
}
