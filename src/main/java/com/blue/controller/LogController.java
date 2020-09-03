package com.blue.controller;
import com.blue.pojo.Book;
import com.blue.pojo.Log;
import com.blue.pojo.User;
import com.blue.result.Result;
import com.blue.service.BookService;
import com.blue.service.LogService;
import com.blue.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/managebooks")
public class LogController {
    private User user;
    
    public void setUser(User user) {
        this.user = user;
    }
    
    @Autowired
    private UserService userService;
    @Autowired
    private BookService bookService;
    @Autowired
    private LogService logService;
    
    @GetMapping("/log")
    public List<Log> listLog() {
        return logService.listLog();
    }
    
    @PostMapping("/back") //因为没有实现权限
    public Result back(@RequestBody Log log) {
        Book book = bookService.findById(log.getBook_id());
        if (book.getLent() <= 0)  //TO-DO：Lent和Total需要同步锁
            return new Result(400);  //不能还了，返回null
        book.setLent(book.getLent() - 1);
        logService.add(log); //还书成功，日志加一，book_lent-1
        bookService.addOrUpdate(book);
        return new Result(200);
    }
    
    @PostMapping("/lend")
    public Result lend(@RequestBody Log log) throws Exception {
        Book book = bookService.findById(log.getBook_id());
        if (book.getLent() >= book.getTotal())  //TO-DO：Lent和Total需要同步锁
            return new Result(400);  //不能借了，返回null
        book.setLent(book.getLent() + 1);
        logService.add(log); //借书成功，日志加一，book_lent+1
        bookService.addOrUpdate(book);
        return new Result(200);
    }
    
}
