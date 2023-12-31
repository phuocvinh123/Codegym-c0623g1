package com.example.demo1.dao;

import com.example.demo1.model.EGender;
import com.example.demo1.model.Role;
import com.example.demo1.model.User;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDao extends DatabaseConnection{

    public void register(User user){
        final String REGISTER_USER = "INSERT INTO `demo1`.`users` (`username`, `password`, `fullName`, `email`, `gender`, `role_id`)  VALUES (?, ?, ?, ?, ?, ?)";
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(REGISTER_USER);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getFullName());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getGender().toString());
            preparedStatement.setInt(6, user.getRole().getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public User findByUsernameOrEmail(String usernameOrEmail){
        var SELECT_BY_ID = "SELECT u.*, r.name role_name " +
                "FROM users u JOIN roles r on " +
                "u.role_id = r.id " +
                "WHERE (u.username = ? or u.email = ?) and u.deleted = '0'";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID)) {
            preparedStatement.setString(1, usernameOrEmail);
            preparedStatement.setString(2, usernameOrEmail);
            System.out.println(preparedStatement);
            var rs = preparedStatement.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setPassword(rs.getString("password"));
                user.setUsername(rs.getString("username"));
                user.setFullName(rs.getString("fullName"));
                user.setEmail(rs.getString("email"));
                user.setGender(EGender.valueOf(rs.getString("gender")));
                user.setRole(new Role(rs.getInt("id"), rs.getString("role_name")));
                return user;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}