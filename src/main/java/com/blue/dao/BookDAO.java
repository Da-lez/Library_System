package com.blue.dao;
import com.blue.pojo.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BookDAO extends JpaRepository<Book,Integer> {
    Book findById(int keyword);
    List<Book> findAllById(int keyword1);
    List<Book> findAllByTitleLikeOrAuthorLikeOrPressLike(String keyword1, String keyword2,String keyword3);
}
