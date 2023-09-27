package com.example.importproduct.service;


import com.example.importproduct.dao.ProductDao;
import com.example.importproduct.model.Product;
import com.example.importproduct.service.dto.Page;

import java.util.List;

public class ProductService {
    private final ProductDao productDAO;

    public ProductService() {
        productDAO = new ProductDao();
    }


    public void create(Product product){
        productDAO.create(product);
    }

    public Page<Product> getProducts(int page, boolean isShowRestore, String search){
        return productDAO.findAll(page, isShowRestore, search);
    }
    public List<Product> findAll(){
        return productDAO.findAll();
    }

    public Product findById(int id){
        return productDAO.findById(id);
    }

    public void update(Product product, int id){
        product.setId(id);
        productDAO.update(product);
    }

    public void restore(String[] ids){
        for (var id : ids) {
            productDAO.restore(Integer.parseInt(id));
        }
    }

    public void delete(int id){
        productDAO.delete(id);
    }
}