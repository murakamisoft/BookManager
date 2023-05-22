package com.bookmanager.book.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bookmanager.book.entity.Book;

@Mapper
public interface BookMapper {

    List<Book> search();
    
}
