package com.example.user.model;



import java.time.LocalDate;
import java.util.Date;

public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private LocalDate dob;
    private Role role;
    private EGender gender;

    public User() {
    }
    public User( String firstName, String lastName, String userName, String email, LocalDate dob, Role role, EGender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
        this.dob = dob;
        this.role = role;
        this.gender = gender;
    }

    public User(int id, String firstName, String lastName, String userName, String email,LocalDate dob, Role role, EGender gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
        this.dob = dob;
        this.role = role;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public EGender getGender() {
        return gender;
    }

    public void setGender(EGender gender) {
        this.gender = gender;
    }
}
