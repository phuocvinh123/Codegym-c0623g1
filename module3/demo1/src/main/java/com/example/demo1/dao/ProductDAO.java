package com.example.demo1.dao;

import com.example.demo1.Service.dto.Page;
import com.example.demo1.model.Category;
import com.example.demo1.model.Product;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ProductDAO  extends DatabaseConnection{


    public Page<Product> findAll(int page){
        Page<Product> result = new Page<>();
        result.setCurrentPage(page);
        List<Product> content = new ArrayList<>();
        String SELECT_ALL = "SELECT p.*, c.name category_name " +
                "FROM products p JOIN categories c on " +
                "c.id = p.category_id " +
                "LIMIT 2 OFFSET ?";
        String SELECT_COUNT = "SELECT COUNT(1) cnt FROM products";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)) {
            preparedStatement.setInt(1, (page-1) * 2);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                var product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setDescription(rs.getString("description"));
                product.setPrice(rs.getBigDecimal("price"));
                product.setCategory(new Category(rs.getInt("category_id"), rs.getString("category_name")));
                content.add(product);
            }
            result.setContent(content);
            PreparedStatement preparedStatementCount = connection.prepareStatement(SELECT_COUNT);
            var rsCount = preparedStatementCount.executeQuery();
            if(rsCount.next()){
                result.setTotalPage((int) Math.ceil((double) rsCount.getInt("cnt") /2));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());;
        }
        return result;
    }
    public void createProduct(Product product){
        String INSERT_PRODUCT = "INSERT INTO products (name, description, price, category_id) VALUES (?, ?, ?, ?)";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT)) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.setBigDecimal(3, product.getPrice());
            preparedStatement.setInt(4, product.getCategory().getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public Product deleteProduct(int productId){
        String DELETE_PRODUCT = "DELETE FROM products WHERE id = ?";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCT)) {
            preparedStatement.setInt(1, productId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    public void updateProduct(Product product){
        String UPDATE_PRODUCT = "UPDATE products SET name = ?, price = ?, description = ?, category_id = ? WHERE id = ?";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCT)) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.setBigDecimal(3, product.getPrice());
            preparedStatement.setInt(4, product.getCategory().getId());
            preparedStatement.setInt(5, product.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}