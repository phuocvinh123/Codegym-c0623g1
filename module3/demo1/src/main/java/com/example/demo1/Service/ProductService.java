package com.example.demo1.Service;

import com.example.demo1.Service.dto.Page;
import com.example.demo1.dao.ProductDAO;
import com.example.demo1.model.Category;
import com.example.demo1.model.EGender;
import com.example.demo1.model.Product;
import com.example.demo1.model.Student;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductService {
    private static List<Product> products=new ArrayList<>() ;
    private final ProductDAO productDAO;

    private static int idCurrent;

    public ProductService() {
        productDAO=new ProductDAO();
    }


    public void create(Product product){
//        product.setId(++idCurrent);
//        products.add(product);
        productDAO.createProduct(product);
    }
    public Page<Product> getProducts(int page){
        return productDAO.findAll(page);
    }


    public List<Product> getProducts(boolean delete){
        return products.stream().filter(product -> product.isDeleted()==delete).collect(Collectors.toList());
    }

    public Product getProductById(int id) {
        return productDAO.deleteProduct(id);
    }
    public void editProduct(int id, String name,BigDecimal price, String description,Category category){
        Product product = getProductById(id);

    }
    public void remove(int id) {
        Product deleteProduct = getProductById(id);
        if (deleteProduct != null) {
            deleteProduct.setDeleted(true);
        }
    }
    public void restore(String[] ids){
       for(int i=0;i<ids.length;i++){
           for(Product p:products){
              if(String.valueOf(p.getId()).equals(ids[i])){
                  p.setDeleted(false);
              }
           }
       }
    }
    public boolean searchProducts(Product product,String keyword) {
        return product.getName().toLowerCase().contains(keyword.toLowerCase())
                || product.getDescription().toLowerCase().contains(keyword.toLowerCase())
                || product.getCategory().getName().toLowerCase().contains(keyword.toLowerCase());


    }
    public List<Product> searchProducts(String keyword) {
        return products.stream().filter(product -> searchProducts(product,keyword)&&!product.isDeleted()).collect(Collectors.toList());
    }
}