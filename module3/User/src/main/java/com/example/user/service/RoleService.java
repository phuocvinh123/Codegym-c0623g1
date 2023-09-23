package com.example.user.service;

import com.example.user.dao.RoleDao;
import com.example.user.model.Role;

import java.util.List;

public class RoleService {
    private final RoleDao roleDaos;

    public RoleService() {
        roleDaos=new RoleDao();
    }
    public List<Role>getRoles(){return roleDaos.findAll();}
    public Role getRole(int id){return roleDaos.findById(id);}
}
