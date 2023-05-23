package com.bookmanager.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookmanager.book.entity.Book;
import com.bookmanager.book.service.BookService;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService BookService;
    
    @GetMapping
    private String list(@ModelAttribute User user, Model model) {
        List<Book> bookList = BookService.search();
        model.addAttribute("bookList", bookList);
        return "book/list";
    }
    

}