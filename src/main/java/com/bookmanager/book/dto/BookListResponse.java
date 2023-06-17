package com.bookmanager.book.dto;

import java.util.List;

import com.bookmanager.book.entity.Book;

import lombok.Data;

@Data
public class BookListResponse {
    private List<Book> bookList;

    public BookListResponse(List<Book> bookList) {
        this.bookList = bookList;
    }
}
