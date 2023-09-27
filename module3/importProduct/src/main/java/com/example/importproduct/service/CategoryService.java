package com.example.importproduct.service;



import com.example.importproduct.dao.CategoryDao;
import com.example.importproduct.model.Category;

import java.util.List;

public class CategoryService {
    private final CategoryDao categoryDAO;

    public CategoryService() {
        categoryDAO = new CategoryDao();
    }

    public List<Category> getCategories(){
        return categoryDAO.findAll();
    }

    public Category getCategory(int id){
        return categoryDAO.findById(id);
    }
}