package com.example.demo1.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student {
    private Integer id;
    private String name;
    private Date dob;
    private EGender gender;
    private boolean deleted = false;

    public Student(Integer id, String name, java.sql.Date dob, EGender gender) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
    }
}
