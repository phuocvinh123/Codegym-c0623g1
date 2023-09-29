package com.example.login.service;

import com.example.login.dao.RoleDao;
import com.example.login.model.Role;

import java.util.List;

public class RoleService {
    private final RoleDao roleDAO;

    public RoleService() {
        roleDAO = new RoleDao();
    }

    public List<Role> getRoles(){
        return roleDAO.findAll();
    }

    public Role getRole(int id){
        return roleDAO.findById(id);
    }
}
