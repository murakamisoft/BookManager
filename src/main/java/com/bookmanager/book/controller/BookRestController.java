package com.bookmanager.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookmanager.book.dto.BookListResponse;
import com.bookmanager.book.dto.BookRequest;
import com.bookmanager.book.dto.BookSaveResponse;
import com.bookmanager.book.entity.Book;
import com.bookmanager.book.service.BookService;

@RestController
@RequestMapping("/api/book")
public class BookRestController {

    @Autowired
    BookService bookService;

    private final int API_USER_ID = 3;
    private final String API_USER_NAME = "api_user";

    /**
     * 一覧取得
     * 
     * @return
     */
    @GetMapping
    public BookListResponse list() {
        List<Book> bookList = bookService.search(3);
        return new BookListResponse(bookList);
    }

    /**
     * 登録
     */
    @PostMapping
    public BookSaveResponse save(@RequestBody @Validated BookRequest request) {
        Integer bookId = bookService.add(API_USER_ID, request.getBookId(), request.getBookName(), API_USER_NAME);
        return new BookSaveResponse(bookId);
    }

}
