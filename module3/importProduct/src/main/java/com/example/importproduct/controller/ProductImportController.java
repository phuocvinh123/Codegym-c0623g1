package com.example.importproduct.controller;



import com.example.importproduct.dao.ProductDao;
import com.example.importproduct.model.Product;
import com.example.importproduct.service.ProductImportService;
import com.example.importproduct.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/product-import", name = "productImportController")
public class ProductImportController extends HttpServlet {
    private ProductService productService;
    private ProductDao productDao;
    private ProductImportService productImportService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action) {
            case "create" -> showCreate(req, resp);
            case "edit" -> showEdit(req,resp);
//            case "restore" -> showRestore(req, resp);
            case "delete" -> delete(req, resp);
            default -> showList(req, resp);
        }

    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        productImportService.delete(req);
        resp.sendRedirect("/product-import?message=Deleted Successfully");
    }

    private void showEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("productImport", productImportService
                .findById(Integer.parseInt(req.getParameter("id"))));
        var products = productService.findAll();
        req.setAttribute("products", products);
        req.setAttribute("productsJSON", new ObjectMapper().writeValueAsString(products));
        req.getRequestDispatcher("product-import/edit.jsp").forward(req,resp);
    }



    private void showCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var products = productService.findAll();
        req.setAttribute("products", products);
        req.setAttribute("productsJSON", new ObjectMapper().writeValueAsString(products));
        req.getRequestDispatcher("product-import/create.jsp").forward(req,resp);
    }

    private void showList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pageString = req.getParameter("page");
        if (pageString == null) {
            pageString = "1";
        }
        req.setAttribute("page", productImportService.findAll(Integer.parseInt(pageString)));
        req.setAttribute("message",req.getParameter("message"));
        req.getRequestDispatcher("product-import/index.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action) {
            case "create" -> create(req, resp);
            case "edit" -> edit(req, resp);
//            case "restore" -> restore(req, resp);
        }
    }

    private void edit(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        productImportService.update(req);
        resp.sendRedirect("/product-import?message=Updated Successfully");
    }

    private void create(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        productImportService.create(req);
        resp.sendRedirect("/product-import?message=Created Successfully");
    }

    @Override
    public void init() throws ServletException {
        productService = new ProductService();
        productImportService = new ProductImportService();
        productDao = new ProductDao();
    }
}