package com.evan.wj.dao;

import com.evan.wj.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDAO extends JpaRepository<User,Integer> {
   //通过用户名查找用户
    User findByUsername(String username);

    //通过用户名查找用户
    User findBytelno(String telno);

    User getBytelnoAndPassword(String telno,String password);
    //获得用户的用户名和密码
    //登录相关
    User getByUsernameAndPassword(String username,String password);
    //增加用户
//    List<User> findAllByUserId();
////    public void addUser(String username,String password,String telno);
}