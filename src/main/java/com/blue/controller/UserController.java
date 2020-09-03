package com.blue.controller;

import com.blue.pojo.User;
import com.blue.result.Result;
import com.blue.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/managebooks")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/user")
    public List<User> listUsers() {
        return userService.list();
    }
    @RequestMapping("/my_info")
    public User MyInfo(@RequestParam("keyword") int keyword) {
        return userService.getById(keyword);
    }
    @PutMapping("/user")
    public Result editUser(@RequestBody @Valid User requestUser) {
        userService.editUser(requestUser);
        return new Result(200);
    }
    @PutMapping("/user/re_pwd")
    public Result re_password(@RequestBody @Valid User requestUser){
        userService.resetPassword(requestUser);
        return new Result(200);
    }
    @PutMapping("/user/delete")
    public Result deleteUser(@RequestBody @Valid User requestUser) {
        userService.deleteById(requestUser.getId());
        return new Result(200);
    }
    @RequestMapping("/user/find_user")
    public User searchResult(@RequestParam("keyword") String keyword) {
        try {
            return userService.getById(Integer.parseInt(keyword));
        } catch (Exception ignored) {
        }
        return userService.get(keyword);
    }
    
    
}
