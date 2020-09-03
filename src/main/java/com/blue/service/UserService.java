package com.blue.service;

import com.blue.dao.UserDAO;
import com.blue.pojo.User;
import javassist.compiler.ast.Keyword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//代理验证
@Service
public class UserService {
    @Autowired
    private UserDAO userDAO;
    
    public List<User> list() {
        return userDAO.findAll();
    }
    
    public User getById(int keyword){
        return userDAO.getById(keyword);
    }
    public User get(String username, String password) {
        return userDAO.getByUsernameAndPassword(username, password);
    }
    public User get(String username){return userDAO.getByUsername(username);}
    public void editUser(User requestUser) {
        User t = userDAO.findByUsername(requestUser.getUsername());
        t.setName(requestUser.getName());
        t.setPhone(requestUser.getPhone());
        userDAO.save(t);
    }
    public void deleteById(int id){
        userDAO.deleteById(id);
    }
    public void resetPassword(User requestUser){
        User t = userDAO.findByUsername(requestUser.getUsername());
        t.setPassword("123");
        userDAO.save(t);
    }

    public User add(User requestUser){
        if(!(requestUser.getUsername().equals("")||requestUser.getPassword().equals("")||requestUser.getName().equals("")))
        return userDAO.save(requestUser);
        else return null;
    }
}
