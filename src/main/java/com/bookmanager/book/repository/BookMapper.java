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

    List<Book> search(Integer userId);

    Book findByBookId(Integer bookId);

    void save(@Param("userId") Integer userId,
            @Param("bookId") Integer bookId,
            @Param("bookName") String bookName,
            @Param("userName") String userName);

    void delete(@Param("userId") Integer userId, @Param("bookId") Integer bookId);

    void update(@Param("userId") Integer userId,
            @Param("bookId") Integer bookId,
            @Param("bookName") String bookName,
            @Param("userName") String userName);

    Book findByUserIdAndBookId(@Param("userId") Integer userId, @Param("bookId") Integer bookId);

}
