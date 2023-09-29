package com.example.login.controller;

import com.example.login.model.Auth;
import com.example.login.model.Role;
import com.example.login.service.AuthService;
import com.example.login.service.RoleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "authController", urlPatterns = "/auth")
public class AuthController extends HttpServlet {
    private AuthService authService;

    private RoleService roleService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action) {
            case "register" -> showRegister(req, resp);
            default -> showLogin(req,resp);

        }

    }

    private void showLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("message", req.getParameter("message"));
        req.getRequestDispatcher("/auth/login.jsp").forward(req,resp);
    }

    private void showRegister(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("roles", roleService.getRoles());
        req.setAttribute("message", req.getParameter("message"));
        req.getRequestDispatcher("auth/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action) {
            case "register" -> register(req, resp);
            default -> login(req,resp);
        }
    }

    private void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if(!authService.login(req,resp)){
            resp.sendRedirect("/auth?message=Invalid username or password");
        }
    }

    private void register(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        authService.register(getUserByRequest(req));
        resp.sendRedirect("/auth?message=Register Success");
    }
    private Auth getUserByRequest(HttpServletRequest req){
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        return new Auth(name,email,password);
    }
    @Override
    public void init() throws ServletException {
        authService = new AuthService();
        roleService = new RoleService();
    }
}
