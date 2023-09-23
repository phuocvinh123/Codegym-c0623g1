package com.example.user.controller;

import com.example.user.HelloServlet;
import com.example.user.dao.RoleDao;
import com.example.user.dao.UserDao;
import com.example.user.model.EGender;
import com.example.user.model.Role;
import com.example.user.model.User;
import com.example.user.service.RoleService;
import com.example.user.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;

@WebServlet(name = "userController", urlPatterns = "/user")
public class UserController extends HelloServlet {
    private UserService userService;
    private RoleService roleService;

    @Override
    public void init() {
        userService = new UserService();
        roleService = new RoleService();
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create" -> showCreate(req, resp);
            case "edit" -> showEdit(req, resp);
            case "restore" -> showRestore(req, resp);
            case "delete" -> delete(req, resp);
            default -> showList(req, resp);
        }
    }


    private void showList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pageString = req.getParameter("page");
        if (pageString == null) {
            pageString = "1";
        }

        req.setAttribute("page", userService.getUsers(Integer.parseInt(pageString)));
        req.setAttribute("message", req.getParameter("message"));
        req.getRequestDispatcher("user/index.jsp").forward(req, resp);
    }

    private void showEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("user", userService.getUsers(Integer.parseInt(req.getParameter("id"))));
        req.setAttribute("role", roleService.getRoles());
        req.getRequestDispatcher("user/create.jsp").forward(req, resp);
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) {

    }

    private void showRestore(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void showCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("user", new User());
        req.setAttribute("gender", EGender.values());
        req.setAttribute("role", roleService.getRoles());
        req.getRequestDispatcher("user/create.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create" -> create(req, resp);
            case "edit" -> edit(req, resp);
            case "restore" -> restore(req, resp);
        }
    }

    private void edit(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        userService.update(getUserByRequest(req), Integer.parseInt(req.getParameter("id")));
        resp.sendRedirect("/user?message=Updated");
    }

    private void restore(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void create(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        userService.create(getUserByRequest(req));
        resp.sendRedirect("/user?message=Created");
    }

    private User getUserByRequest(HttpServletRequest req) {
        String firstname = req.getParameter("firstName");
        String lastname = req.getParameter("lastName");
        String username = req.getParameter("userName");
        String email = req.getParameter("email");
        Date dob = Date.valueOf(req.getParameter("dob"));
        String idRole = req.getParameter("role");
        Role role = new Role(Integer.parseInt(idRole));
        EGender gender = EGender.valueOf(req.getParameter("gender"));
        return new User(firstname, lastname, username, email, dob.toLocalDate(), role, gender);
    }
}
