package com.example.login.dao;

import com.example.login.model.Auth;
import com.example.login.model.Role;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AuthDao extends DatabaseConnection{
    public void register(Auth auth){
        final String REGISTER_USER = "INSERT INTO `login`.`logins` (`name`, `email`, `password` ) VALUES (?,?,?)";
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(REGISTER_USER);
            preparedStatement.setString(1, auth.getName());
            preparedStatement.setString(2, auth.getEmail());
            preparedStatement.setString(3, auth.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Auth findByUsernameOrEmail(String usernameOrEmail){
        var SELECT_BY_ID = "SELECT l.*, r.name role_name " +
                " FROM logins l JOIN roles r on " +
                " l.role_id = r.id " +
                " WHERE  l.email = ? ";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID)) {
            preparedStatement.setString(1, usernameOrEmail);
            System.out.println(preparedStatement);
            var rs = preparedStatement.executeQuery();
            if (rs.next()) {
                Auth auth = new Auth();
                auth.setId(rs.getInt("id"));
                auth.setName(rs.getString("name"));
                auth.setEmail(rs.getString("email"));
                auth.setPassword(rs.getString("password"));
                auth.setRole(new Role(rs.getInt("id"), rs.getString("role_name")));
                return auth;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
