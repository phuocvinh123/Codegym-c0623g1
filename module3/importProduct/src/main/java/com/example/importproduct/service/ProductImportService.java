package com.example.importproduct.service;



import com.example.importproduct.dao.ProductImportDAO;
import com.example.importproduct.model.ProductImport;
import com.example.importproduct.service.dto.Page;
import com.example.importproduct.service.dto.ProductImportListResponse;
import com.example.importproduct.service.dto.Show;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Arrays;
import java.util.List;

public class ProductImportService {

    private ProductImportDAO productImportDAO;

    public ProductImportService() {
        productImportDAO = new ProductImportDAO();
    }

    public void create(HttpServletRequest req) {
        Date importDate = Date.valueOf(req.getParameter("importDate"));
        String code = req.getParameter("code");
        List<Integer> productIds = Arrays.stream(req.getParameterValues("productIds"))
                .map(Integer::parseInt).toList();

        List<Integer> quantities = Arrays.stream(req.getParameterValues("quantities"))
                .map(Integer::parseInt).toList();
        List<BigDecimal> amounts = Arrays.stream(req.getParameterValues("amounts"))
                .map(BigDecimal::new).toList();

        BigDecimal totalAmount = BigDecimal.ZERO;
        for (int i = 0; i < quantities.size(); i++) {
            // totalAmount += quantity * amount;
            totalAmount = totalAmount.add(amounts.get(i).multiply(BigDecimal.valueOf(quantities.get(i))));
        }
        ProductImport productImport = new ProductImport(0, code,importDate,totalAmount);
        productImport.setId(productImportDAO.create(productImport));

        for (int i = 0; i < quantities.size(); i++) {
            productImportDAO.createImportDetail(productImport.getId(), productIds.get(i), quantities.get(i), amounts.get(i));
        }

    }

    public Page<ProductImportListResponse> findAll(int page){
        return productImportDAO.findAll(page);
    }

    public List<Show> findAllShow(int id){
        return productImportDAO.findAllShow(id);
    }

}