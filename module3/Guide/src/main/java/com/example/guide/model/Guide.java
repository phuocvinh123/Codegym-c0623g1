package com.example.guide.model;

import com.example.guide.Enum.EGender;
import com.example.guide.Enum.EStatusGuide;

import java.time.LocalDate;
import java.util.List;

public class Guide {
    private int id;
    private String userName;
    private String passWord;
    private String name;
    private LocalDate age;
    private String address;
    private String phone;
    private EGender eGender;
    private EStatusGuide eStatusGuide;
    private double price;
}
