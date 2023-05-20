package com.bookmanager.book;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class BookController {
    @GetMapping("/list")
    private String list(@ModelAttribute User user) {
        return "book";
    }
    

}