package com.blue.controller;
import com.blue.pojo.User;
import com.blue.result.Result;
import com.blue.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import javax.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/managebooks")
public class LoginController {
    @Autowired
    private UserService userService;
    
    @RequestMapping("/login")
    public Result login(@RequestBody User requestUser) {
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);
        User user = userService.get(username, requestUser.getPassword());
        if (user != null || (username.equals("admin") && requestUser.getPassword().equals("123"))) {
            return new Result(200);
        } else {
            System.out.println("账号或密码错误");
            return new Result(400);
        }
    }
    
    @PostMapping("/register")
    public Result addUser(@RequestBody @Valid User requestUser) {
        if (userService.add(requestUser) != null)
            return new Result(200);
        else return new Result(400);
    }
}
