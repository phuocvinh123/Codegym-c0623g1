package com.example.demo1.controller;

import com.example.demo1.Service.AuthorService;
import com.example.demo1.Service.BookService;
import com.example.demo1.Service.CategoryService;
import com.example.demo1.model.Book;
import com.example.demo1.model.Product;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "bookController", urlPatterns = "/book")
public class BookController extends HttpServlet {
    private BookService bookService;
    private CategoryService categoryService;
    private AuthorService authorService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreate(req, resp);
                break;
            case "edit":
                showEdit(req, resp);
                break;
            case "showRestore":
                showRestore(req, resp);
                break;
            case "restore":
                restore(req, resp);
                break;
            case "delete":
                delete(req, resp);
                break;
            default:
                showList(req, resp);
        }
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id=Integer.parseInt(req.getParameter("id"));
        bookService.remove(id);
        resp.sendRedirect("/book?message=Deleted");
    }

    private void restore(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String[] ids=req.getParameter("id").split(",");
        bookService.restore(ids);
        resp.sendRedirect("/book?action=showRestore&message=Restored");
    }

    private void showRestore(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("books", bookService.getBooks(true));
        req.setAttribute("message", req.getParameter("message"));
        req.getRequestDispatcher("book/restore.jsp").forward(req, resp);
    }

    private void showEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Book book=bookService.getBookById(id);
        req.setAttribute("categories", categoryService.getCategories());
        req.setAttribute("authors", authorService.findAll());
        req.setAttribute("book",book);
        req.getRequestDispatcher("/book/edit.jsp").forward(req, resp);
    }

    private void showList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("books", bookService.getBooks(false));
        req.setAttribute("message", req.getParameter("message"));
        req.getRequestDispatcher("/book/index.jsp").forward(req, resp);
    }

    private void showCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("categories", categoryService.getCategories());
        req.setAttribute("authors", authorService.findAll());
        req.getRequestDispatcher("/book/create.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                create(req, resp);
                break;
            case "edit":
                edit(req, resp);
                break;
            case "search":
                search(req, resp);
                break;
        }
    }

    private void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String inputSearch=req.getParameter("inputSearch");
        req.setAttribute("books",bookService.searchProducts(inputSearch));
        req.getRequestDispatcher("book/index.jsp").forward(req,resp);
    }

    private void edit(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        bookService.editBooks(req);
        resp.sendRedirect("/book?message=Edited");
    }

    private void create(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        bookService.create(req);
        resp.sendRedirect("/book?message=Created");
    }

    @Override
    public void init() {
        bookService = new BookService();
        categoryService = new CategoryService();
        authorService = new AuthorService();
    }
}