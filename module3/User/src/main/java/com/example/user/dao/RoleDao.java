package com.example.user.dao;

import com.example.user.model.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleDao extends DatabaseConnection {
    public List<Role> findAll(){
        List<Role> reRoles=new ArrayList<>();
        String SELECT_ALL="select * from roles";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)) {

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                reRoles.add(new Role(rs.getInt("id"), rs.getString("name")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());;
        }
        return reRoles;
    }

    public Role findById(int id){
        String SELECT_BY_ID = "SELECT * FROM roles WHERE id = ?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return new Role(rs.getInt("id"), rs.getString("name"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());;
        }
        return null;
    }
    }

