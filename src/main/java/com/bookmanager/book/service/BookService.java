package com.bookmanager.book.service;

import java.util.List;

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
    public List<Book> search() {
        return bookMapper.search();
    }

    /**
     * 追加
     * 
     * @param bookName
     */
    public void add(String bookName) {
        bookMapper.save(bookName);
    }

    /**
     * 削除
     * 
     * @param bookId
     */
    public void delete(Integer bookId) {
        bookMapper.delete(bookId);
    }

}
