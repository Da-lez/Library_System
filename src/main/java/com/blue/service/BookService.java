package com.blue.service;

import com.blue.dao.BookDAO;
import com.blue.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookDAO bookDAO;
    
    public List<Book> list() {
        return bookDAO.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }
    
    public void addOrUpdate(Book book) {
        bookDAO.save(book);
    }
    
    public void deleteById(int id) {
        bookDAO.deleteById(id);
    }
    
    public List<Book> findAllById(int keywords) {
        return bookDAO.findAllById(keywords);
    }
    
    public Book findById(int keyword) {
        return bookDAO.findById(keyword);
    }
    
    public List<Book> findLikely(String keywords) {
        return bookDAO.findAllByTitleLikeOrAuthorLikeOrPressLike('%' + keywords + '%', '%' + keywords + '%', '%' + keywords + '%');
    }
    
}

