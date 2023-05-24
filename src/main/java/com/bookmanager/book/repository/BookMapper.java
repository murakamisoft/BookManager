package com.bookmanager.book.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.bookmanager.book.entity.Book;

/**
 * 本のマッパー
 */
@Mapper
public interface BookMapper {

    List<Book> search();

    Book findByBookId(Integer bookId);

    void save(String bookName);

    void delete(Integer bookId);

    void update(@Param("bookId") Integer bookId, @Param("bookName") String bookName);

}
