package com.evan.wj.service;

import com.evan.wj.dao.UserDAO;
import com.evan.wj.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserDAO userDAO;

    public boolean isExist(String username) {
        User user = getByName(username);
        return null!=user;
    }

    public User getByName(String username) {
        return userDAO.findByUsername(username);
    }

    public boolean isExists(String telno) {
        User user = getBytelno(telno);
        return null!=user;
    }

    public User getBytelno(String telno) {
        return userDAO.findBytelno(telno);
    }

    public User Get(String telno, String password){
        return userDAO.getBytelnoAndPassword(telno, password);
    }
//登录相关
    public User get(String username, String password){
        return userDAO.getByUsernameAndPassword(username, password);
    }

    public void register(User user) {
       userDAO.save(user);
    }
}