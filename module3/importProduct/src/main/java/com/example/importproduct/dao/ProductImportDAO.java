package com.example.importproduct.dao;


import com.example.importproduct.model.Product;
import com.example.importproduct.model.ProductImport;
import com.example.importproduct.service.dto.Page;
import com.example.importproduct.service.dto.ProductImportListResponse;
import com.example.importproduct.service.dto.Show;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductImportDAO extends DatabaseConnection {


    public int create(ProductImport productImport) {
        String CREATE = "INSERT INTO `product`.`product_imports` (`code`, `import_date`, `total_amount`) " +
                "VALUES (?, ?, ?)";
        String SELECT_MAX_ID = "SELECT MAX(id) as max_id FROM `product`.`product_imports`";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE)) {
            preparedStatement.setString(1, productImport.getCode());
            preparedStatement.setDate(2, productImport.getImportDate());
            preparedStatement.setBigDecimal(3, productImport.getTotalAmount());
            preparedStatement.executeUpdate();
            PreparedStatement statementId = connection.prepareStatement(SELECT_MAX_ID);
            var rs = statementId.executeQuery();
            if (rs.next()) {
                return rs.getInt("max_id");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            ;
        }
        return -1;
    }

    public void createImportDetail(int productImportId, int productId, int quantity, BigDecimal amount) {

        String CREATE = "INSERT INTO `product`.`product_import_details` (`quantity`, `amount`, `product_id`, `product_import_id`) VALUES (?, ?, ?, ?)";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE)) {
            preparedStatement.setInt(1, quantity);
            preparedStatement.setBigDecimal(2, amount);
            preparedStatement.setInt(3, productId);
            preparedStatement.setInt(4, productImportId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            ;
        }
    }

    public Page<ProductImportListResponse> findAll(int page) {
        var result = new Page<ProductImportListResponse>();
        final int TOTAL_ELEMENT = 3;
        result.setCurrentPage(page);
        var content = new ArrayList<ProductImportListResponse>();
        String SELECT_ALL = "SELECT pi.id, pi.`code`, pi.import_date, GROUP_CONCAT(p.`name`) products, pi.total_amount FROM " +
                "product_imports pi " +
                "LEFT JOIN product_import_details pid on pi.id = pid.product_import_id " +
                "LEFT JOIN products p on p.id = pid.product_id GROUP BY pi.id" +
                " LIMIT ? OFFSET ?";
        ;
        var SELECT_COUNT = "SELECT COUNT(1) cnt " +
                "FROM product_imports pi " +
                "LEFT JOIN product_import_details pid on pi.id = pid.product_import_id " +
                "LEFT JOIN products p on p.id = pid.product_id GROUP BY pi.id";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)) {
            preparedStatement.setInt(1,TOTAL_ELEMENT);
            preparedStatement.setInt(2, (page - 1) * TOTAL_ELEMENT);
            System.out.println(preparedStatement);
            var rs = preparedStatement.executeQuery();
            while (rs.next()) {
                content.add(new ProductImportListResponse(
                        rs.getInt("id"),
                        rs.getString("code"),
                        rs.getDate("import_date"),
                        rs.getString("products"),
                        rs.getBigDecimal("total_amount")
                ));
            }
            result.setContent(content);
            var preparedStatementCount = connection.prepareStatement(SELECT_COUNT);
            var rsCount = preparedStatementCount.executeQuery();
            if(rsCount.next()){
                result.setTotalPage((int) Math.ceil((double) rsCount.getInt("cnt") /TOTAL_ELEMENT));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return  result;
    }
    public List<Show> findAllShow(int id){
        var result = new ArrayList<Show>();
        String SELECT_ALL = "SELECT pid.id ,p.`name` as `product` ,pid.`quantity`,pid.`amount` FROM " +
                "  product_imports pi  " +
                " JOIN product_import_details pid on pi.id = pid.product_import_id" +
                " JOIN products p on p.id = pid.product_id where pi.id= ? ";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)) {
            preparedStatement.setInt(1, id );
            System.out.println(preparedStatement);
            var rs = preparedStatement.executeQuery();
            while (rs.next()) {
                result.add(new Show(
                        rs.getInt("id"),
                        rs.getString("product"),
                        rs.getInt("quantity"),
                        rs.getBigDecimal("amount")
                ));
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return result;
    }

}