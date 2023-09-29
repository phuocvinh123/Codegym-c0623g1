package com.example.login.service;

import com.example.login.dao.AuthDao;
import com.example.login.model.Auth;
import com.example.login.util.PasswordEncryptionUtil;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthService {
    private AuthDao authDao;

    public AuthService() {
        authDao = new AuthDao();
    }

    public void register(Auth auth){
        auth.setPassword(PasswordEncryptionUtil.encryptPassword(auth.getPassword()));
        authDao.register(auth);
    }

    public boolean login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String usernameOrEmail = req.getParameter("username");
        String password = req.getParameter("password");
        var auth = authDao.findByUsernameOrEmail(usernameOrEmail);
        if(auth != null && PasswordEncryptionUtil.checkPassword(password, auth.getPassword())){
            HttpSession session = req.getSession();
            session.setAttribute("auth", auth); // luu vo kho
            if(auth.getRole().getName().equals("ADMIN")){
                resp.sendRedirect("/book?message=Login Success");
            }else{
                resp.sendRedirect("/product?message=Login Success");
            }
            return true;
        }
        return false;
    }
}
