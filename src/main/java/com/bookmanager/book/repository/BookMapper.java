package com.bookmanager.book.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bookmanager.book.entity.Book;

/**
 * 本のマッパー
 */
@Mapper
public interface BookMapper {

    List<Book> search();

    void save(String bookName);

    void delete(Integer bookId);

}
