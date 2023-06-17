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

    Integer save(@Param("userId") Integer userId,
            @Param("bookId") Integer bookId,
            @Param("bookName") String bookName,
            @Param("userName") String userName);

    Integer delete(@Param("userId") Integer userId, @Param("bookId") Integer bookId);

    Integer update(@Param("userId") Integer userId,
            @Param("bookId") Integer bookId,
            @Param("bookName") String bookName,
            @Param("userName") String userName);

    Book findByUserIdAndBookId(@Param("userId") Integer userId, @Param("bookId") Integer bookId);

}
