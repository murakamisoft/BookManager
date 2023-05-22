package com.bookmanager.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookmanager.book.entity.Book;
import com.bookmanager.book.repository.BookMapper;

@Service
public class BookService {

    @Autowired
    BookMapper bookMapper;

    public List<Book> search() {
        return bookMapper.search();
    }

}
