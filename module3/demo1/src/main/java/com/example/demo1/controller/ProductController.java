package com.example.demo1.controller;

import com.example.demo1.Service.CategoryService;
import com.example.demo1.Service.ProductService;
import com.example.demo1.model.Category;
import com.example.demo1.model.Product;
import com.example.demo1.model.Student;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@WebServlet(name = "productController", urlPatterns = "/product")
public class ProductController extends HttpServlet {
    private ProductService productService;
    private CategoryService categoryService;
    @Override
    public void init() throws ServletException {
        productService = new ProductService();
        categoryService = new CategoryService();

    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                showCreate(req,resp);
                break;
            case "edit":
                showEdit(req,resp);
                break;
            case "showRestore":
                showRestore(req,resp);
                break;
            case "restore":
                restore(req,resp);
                break;
            case "delete":
                delete(req, resp);
                break;

            default:
                showList(req,resp);
        }
    }


    private void restore(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String[] ids=req.getParameter("id").split(",");
        productService.restore(ids);
        resp.sendRedirect("product?action=showRestore&message=Restored");
    }
    private void showRestore(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("products", productService.getProducts(true));
        req.setAttribute("message", req.getParameter("message"));
        req.getRequestDispatcher("product/restore.jsp").forward(req, resp);
    }
    private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        int id = Integer.parseInt(req.getParameter("id"));
        productService.remove(id);
        resp.sendRedirect("/product?message=Deleted");
    }

    private void showEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Product product=this.productService.getProductById(id);
        req.setAttribute("categories",categoryService.getCategories());
        req.setAttribute("product",product);
        req.getRequestDispatcher("product/edit.jsp").forward(req,resp);
    }

//    private void showList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setAttribute("products", productService.getProducts(false));
//        req.setAttribute("message", req.getParameter("message"));
//        req.getRequestDispatcher("product/index.jsp").forward(req, resp);
//    }
private void showList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String pageString = req.getParameter("page");
    if(pageString == null){
        pageString = "1";
    }

    req.setAttribute("page", productService.getProducts(Integer.parseInt(pageString)));
    req.setAttribute("message", req.getParameter("message"));
    req.getRequestDispatcher("product/index.jsp").forward(req, resp);
}

    private void showCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("categories", categoryService.getCategories());
        req.getRequestDispatcher("product/create.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                create(req,resp);
                break;
            case "edit":
                edit(req,resp);
                break;
            case "search":
                search(req, resp);
                break;
        }
    }
    private void search(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String inputSearch=req.getParameter("inputSearch");
        req.setAttribute("products",productService.searchProducts(inputSearch));
        req.getRequestDispatcher("product/index.jsp").forward(req,resp);
    }

    private void edit(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        BigDecimal price = new BigDecimal(req.getParameter("price"));
        String description = req.getParameter("description");
        String idCategory = req.getParameter("category");
        Category category = categoryService.getCategory(Integer.parseInt(idCategory));
        Product product=productService.getProductById(id);
        productService.editProduct(product.getId(),name,price,description,category);
        resp.sendRedirect("/product?message=Created");
    }

    private void create(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        BigDecimal price = new BigDecimal(req.getParameter("price"));
        String description = req.getParameter("description");
        String idCategory = req.getParameter("category");
        Category category = categoryService.getCategory(Integer.parseInt(idCategory));
        productService.create(new Product(name, price,description,category));
        resp.sendRedirect("/product?message=Created");
    }


}