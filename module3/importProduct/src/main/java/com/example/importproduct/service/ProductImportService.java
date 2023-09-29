package com.example.importproduct.service;


import com.example.importproduct.dao.ProductImportDAO;
import com.example.importproduct.model.ProductImport;
import com.example.importproduct.service.dto.Page;
import com.example.importproduct.service.dto.ProductImportListResponse;

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
        ProductImport productImport = new ProductImport(0, code, importDate, totalAmount);
        productImport.setId(productImportDAO.create(productImport));

        for (int i = 0; i < quantities.size(); i++) {
            productImportDAO.createImportDetail(productImport.getId(), productIds.get(i), quantities.get(i), amounts.get(i));
        }

    }

    public void update(HttpServletRequest req) {
        // lay id product import
        // xoa het product import detail cua thang pi
        // cap nha product import
        // them moi product import detail ma nguoi dung gui len
        int idProductImport = Integer.parseInt(req.getParameter("id"));
        productImportDAO.deleteImportDetail(idProductImport);
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
        ProductImport productImport = new ProductImport(idProductImport, code,importDate,totalAmount);
        productImportDAO.updateProductImport(productImport);

        for (int i = 0; i < quantities.size(); i++) {
            productImportDAO.createImportDetail(productImport.getId(), productIds.get(i), quantities.get(i), amounts.get(i));
        }
    }
    public ProductImport findById(int id){
        return productImportDAO.findById(id);
    }
    public Page<ProductImportListResponse> findAll(int page,boolean isShowRestore ,String search) {
        return productImportDAO.findAll(page ,isShowRestore,search);
    }


    public void delete(HttpServletRequest req) {
        int id = Integer.parseInt(req.getParameter("id"));
        productImportDAO.deleteImportDetail1(id);
        productImportDAO.deleteProductImport(id);
    }
    public void restore(String[] ids){
        for (var id : ids) {
            productImportDAO.restoreProductImport(Integer.parseInt(id));
            productImportDAO.restoreImportDetail1(Integer.parseInt(id));
        }
    }
}