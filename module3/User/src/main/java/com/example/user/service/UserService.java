package com.example.user.service;

import com.example.user.dao.UserDao;
import com.example.user.model.User;
import com.example.user.service.dto.Page;

public class UserService {
private final UserDao userDaos;

    public UserService() {
        userDaos =new UserDao();
    }
    public Page<User> getUsers(int page,boolean isShowRestore,String search){
        return userDaos.findAll(page,isShowRestore,search);
    }
    public User findById(int id){
        return userDaos.findById(id);
    }
    public void create(User user){
        userDaos.create(user);
    }
    public void update(User user, int id){
        user.setId(id);
        userDaos.update(user);
    }
    public void delete(int id){
        userDaos.delete(id);
    }

    public void restore(String[] ids){
        for (var id : ids) {
            userDaos.restore(Integer.parseInt(id));
        }
    }
}
