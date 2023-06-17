package com.bookmanager.book.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookmanager.book.entity.Book;
import com.bookmanager.book.repository.BookMapper;

/**
 * 本のサービス
 */
@Service
public class BookService {

    @Autowired
    BookMapper bookMapper;

    /**
     * 一覧検索
     * 
     * @return
     */
    public List<Book> search(Integer userId) {
        return bookMapper.search(userId);
    }

    /**
     * 追加
     * 
     * @param userId
     * @param bookId
     * @param bookName
     * @param userName
     */
    public Integer add(Integer userId, Integer bookId, String bookName, String userName) {
        return bookMapper.save(userId, bookId, bookName, userName);
    }

    /**
     * 削除
     * 
     * @param userId
     * @param bookId
     */
    public void delete(Integer userId, Integer bookId) {
        bookMapper.delete(userId, bookId);
    }

    /**
     * １件取得
     * 
     * @param bookId
     * @param bookId2
     * @return
     */
    public Book findByBookId(Integer userId, Integer bookId) {
        return bookMapper.findByUserIdAndBookId(userId, bookId);
    }

    /**
     * 更新
     * 
     * @param userId
     * @param bookId
     * @param bookName
     * @param userName
     */
    public void update(Integer userId, Integer bookId, String bookName, String userName) {
        bookMapper.update(userId, bookId, bookName, userName);
    }

    public boolean existBookId(Integer userId, Integer bookId) {
        Book book = bookMapper.findByUserIdAndBookId(userId, bookId);
        return !Objects.isNull(book);
    }

}
