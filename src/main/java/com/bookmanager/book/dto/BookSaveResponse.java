package com.bookmanager.book.dto;

import lombok.Data;

@Data
public class BookSaveResponse {
    private Integer bookId;

    public BookSaveResponse(Integer bookId) {
        this.bookId = bookId;
    }
}
