package com.example.user.dao;

import com.example.user.model.EGender;
import com.example.user.model.Role;
import com.example.user.model.User;
import com.example.user.service.dto.Page;


import java.sql.*;
import java.util.ArrayList;

public class UserDao extends DatabaseConnection{
    public Page<User> findAll(int page, boolean isShowRestore,String search){
        var result = new Page<User>();
        final int TOTAL_ELEMENT = 3;
        result.setCurrentPage(page);
        var content = new ArrayList<User>();
        if(search == null){
            search = "";
        }
        search = "%" + search.toLowerCase() + "%";
        final var DELETED = isShowRestore ? 1 : 0;
        var SELECT_ALL = "SELECT u.*, r.name role_name " +
                "FROM users u JOIN roles r on r.id = u.Role_id WHERE u.deleted = ? AND" +
                "(LOWER(u.firstName) LIKE ? OR LOWER(u.lastName) LIKE ? OR LOWER(r.name) LIKE ? OR LOWER(u.userName) LIKE ? OR LOWER(u.email) LIKE ?)" +
                "Order by u.id  LIMIT ? OFFSET ? ";

        var SELECT_COUNT = "SELECT COUNT(1) cnt FROM users u JOIN roles r on r.id = u.Role_id WHERE u.deleted = ? AND" +
                "(LOWER(u.firstName) LIKE ? OR LOWER(u.lastName) LIKE ? OR LOWER(r.name) LIKE ? OR LOWER(u.userName) LIKE ? OR LOWER(u.email) LIKE ?)";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)) {
            preparedStatement.setInt(1, DELETED );
            preparedStatement.setString(2, search);
            preparedStatement.setString(3, search);
            preparedStatement.setString(4, search);
            preparedStatement.setString(5, search);
            preparedStatement.setString(6, search);
            preparedStatement.setInt(7,TOTAL_ELEMENT);
            preparedStatement.setInt(8, (page - 1) * TOTAL_ELEMENT);
            System.out.println(preparedStatement);
            var rs = preparedStatement.executeQuery();
            while (rs.next()) {
                content.add(getUserByResultSet(rs));
            }
            result.setContent(content);
            var preparedStatementCount = connection.prepareStatement(SELECT_COUNT);
            preparedStatementCount.setInt(1,DELETED );
            preparedStatementCount.setString(2, search);
            preparedStatementCount.setString(3, search);
            preparedStatementCount.setString(4, search);
            preparedStatementCount.setString(5, search);
            preparedStatementCount.setString(6, search);
            var rsCount = preparedStatementCount.executeQuery();
            if(rsCount.next()){
                result.setTotalPage((int) Math.ceil((double) rsCount.getInt("cnt") /TOTAL_ELEMENT));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());;
        }
        return result;
    }



    public User findById(int id){
        var SELECT_BY_ID = "SELECT u.*, r.name role_name " +
                "FROM users u JOIN roles r on " +
                "r.id = u.Role_id " +
                "WHERE u.id = ? and u.deleted = '0'";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID)) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            var rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return getUserByResultSet(rs);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    public void create(User users){
        String CREATE = "INSERT INTO `employee`.`users` (`FirstName`, `LastName`, `Username`, `Email`, `Dob`, `Role_id`, `Gender`) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE)) {
            preparedStatement.setString(1,users.getFirstName());
            preparedStatement.setString(2, users.getLastName());
            preparedStatement.setString(3, users.getUserName());
            preparedStatement.setString(4, users.getEmail());
            preparedStatement.setDate(5, Date.valueOf(users.getDob()) );
            preparedStatement.setInt(6, users.getRole().getId());
            preparedStatement.setString(7, String.valueOf(users.getGender()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());;
        }
    }

    public void update(User users){
        String UPDATE = "UPDATE `employee`.`users` " +
                "SET `FirstName` = ?, `Lastname` = ?, `UserName` = ?, `Email` = ? , `Dob` = ? , `Role_id` = ?, `Gender` = ?" +
                "WHERE (`id` = ?)";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)) {
            preparedStatement.setString(1,users.getFirstName());
            preparedStatement.setString(2, users.getLastName());
            preparedStatement.setString(3, users.getUserName());
            preparedStatement.setString(4, users.getEmail());
            preparedStatement.setDate(5,  Date.valueOf(users.getDob()));
            preparedStatement.setInt(6, users.getRole().getId());
            preparedStatement.setString(7, String.valueOf(users.getGender()));
            preparedStatement.setInt(8, users.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());;
        }
    }

    public void delete(int id){
        String DELETE = "UPDATE `employee`.`users` " +
                "SET `deleted` = '1' " +
                "WHERE (`id` = ?)";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE)) {
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());;
        }
    }
    public void restore(int id){
        String DELETE = "UPDATE `employee`.`users` " +
                "SET `deleted` = '0' " +
                "WHERE (`id` = ?)";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE)) {
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());;
        }
    }


    private User getUserByResultSet(ResultSet rs) throws SQLException {
        var users = new User();
        users.setId(rs.getInt("id"));
        users.setFirstName(rs.getString("firstName"));
        users.setLastName(rs.getString("lastName"));
        users.setUserName(rs.getString("userName"));
        users.setEmail(rs.getString("email"));
        users.setDob(rs.getDate("dob").toLocalDate());
        users.setRole(new Role(rs.getInt("role_id"), rs.getString("role_name")));
        users.setGender(EGender.valueOf(rs.getString("gender")));
        return users;
    }


}
