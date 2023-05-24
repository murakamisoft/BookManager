package com.bookmanager.book.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookmanager.book.dto.BookRequest;
import com.bookmanager.book.entity.Book;
import com.bookmanager.book.service.BookService;

/**
 * 本のコントローラ
 */
@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    /**
     * 一覧取得
     * 
     * @param model
     * @return
     */
    @GetMapping
    public String list(Model model) {
        List<Book> bookList = bookService.search();
        model.addAttribute("bookList", bookList);
        return "book/list";
    }

    /**
     * 追加画面表示
     * 
     * @param model
     * @return
     */
    @GetMapping("/add")
    public String displayAdd(Model model) {
        model.addAttribute("bookRequest", new BookRequest());
        return "book/add";
    }

    /**
     * 追加
     * 
     * @param model
     * @return
     */
    @PostMapping
    public String add(@Validated @ModelAttribute BookRequest bookRequest, BindingResult result, Model model) {
        if (result.hasErrors()) {
            // 入力チェックエラーの場合
            List<String> errorList = new ArrayList<String>();
            for (ObjectError error : result.getAllErrors()) {
                errorList.add(error.getDefaultMessage());
            }
            model.addAttribute("validationError", errorList);
            return "book/add";
        }
        // 本の追加
        bookService.add(bookRequest.getBookName());
        return "redirect:/book";
    }
}