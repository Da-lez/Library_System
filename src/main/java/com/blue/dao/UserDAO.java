package com.blue.dao;
import com.blue.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserDAO extends JpaRepository<User,Integer> {
    User findByUsername(String username);
    User getByUsernameAndPassword(String username,String password);
    User getById(int id);
    User getByUsername(String username);
}
