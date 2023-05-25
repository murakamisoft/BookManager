package com.bookmanager.book.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookmanager.book.dto.BookRequest;
import com.bookmanager.book.entity.Book;
import com.bookmanager.book.service.BookService;

import jakarta.validation.Valid;

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

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        // Principalからログインユーザの情報を取得
        String userName = auth.getName();
        model.addAttribute("userName", userName);

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

    /**
     * 削除
     * 
     * @param bookId
     * @return
     */
    @DeleteMapping("{bookId}")
    public String delete(@PathVariable Integer bookId) {
        bookService.delete(bookId);
        return "redirect:/book";
    }

    /**
     * 編集画面表示
     * 
     * @param model
     * @return
     */
    @GetMapping("/edit/{bookId}")
    public String displayEdit(@PathVariable Integer bookId, Model model) {
        Book book = bookService.findByBookId(bookId);
        model.addAttribute("bookRequest", book);
        return "book/edit";
    }

    /**
     * 編集画面の更新処理
     */
    @PutMapping("/edit")
    public String edit(@ModelAttribute @Valid BookRequest bookRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "book/edit";
        }
        bookService.update(bookRequest.getBookId(), bookRequest.getBookName());
        return "redirect:/book";
    }
}