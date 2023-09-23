package com.example.user.service;

import com.example.user.dao.UserDao;
import com.example.user.model.User;
import com.example.user.service.dto.Page;

public class UserService {
private final UserDao userDaos;

    public UserService() {
        userDaos =new UserDao();
    }
    public Page<User> getUsers(int page){
        return userDaos.findAll(page);
    }
    public void create(User user){
        userDaos.create(user);
    }
    public void update(User user, int id){
        user.setId(id);
        userDaos.update(user);
    }
}
