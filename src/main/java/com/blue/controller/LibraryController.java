package com.blue.controller;

import com.blue.pojo.Book;
import com.blue.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/managebooks")
public class LibraryController {
    @Autowired
    private BookService bookService;
    
    @GetMapping("/books")
    public List<Book> list() throws Exception {
        return bookService.list();
    }
    
    @PostMapping("/books")
    public Book addOrUpdate(@RequestBody Book book) throws Exception {
        bookService.addOrUpdate(book);
        return book;
    }
    
    @RequestMapping("/delete")
    public void delete(@RequestBody Book book) throws Exception {
        bookService.deleteById(book.getId());
    }
    
    @RequestMapping("/search")
    public List<Book> searchResult(@RequestParam("keywords") String keywords) {
        try {
            return bookService.findAllById(Integer.parseInt(keywords));
        } catch (Exception ignored) {
        }
        if ("".equals(keywords))
            return bookService.list();
        else
            return bookService.findLikely(keywords);
    }
}