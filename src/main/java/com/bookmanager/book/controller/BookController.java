package com.bookmanager.book.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
import com.bookmanager.security.LoginUserDetails;

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
    public String list(@AuthenticationPrincipal LoginUserDetails user, Model model) {

        model.addAttribute("userName", user.getUsername());

        List<Book> bookList = bookService.search(user.getUserId());
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
    public String add(@AuthenticationPrincipal LoginUserDetails user,
            @Validated @ModelAttribute BookRequest bookRequest,
            BindingResult result,
            Model model) {
        if (result.hasErrors()) {
            // 入力チェックエラーの場合
            List<String> errorList = new ArrayList<String>();
            for (ObjectError error : result.getAllErrors()) {
                errorList.add(error.getDefaultMessage());
            }
            model.addAttribute("validationError", errorList);
            return "book/add";
        }
        if (bookService.existBookId(user.getUserId(), bookRequest.getBookId())) {
            List<String> errorList = new ArrayList<String>();
            errorList.add("book id is exist.");
            model.addAttribute("validationError", errorList);
            return "book/add";
        }
        // 本の追加
        bookService.add(user.getUserId(), bookRequest.getBookId(), bookRequest.getBookName());
        return "redirect:/book";
    }

    /**
     * 削除
     * 
     * @param bookId
     * @return
     */
    @DeleteMapping("{bookId}")
    public String delete(@AuthenticationPrincipal LoginUserDetails user, @PathVariable Integer bookId) {
        bookService.delete(user.getUserId(), bookId);
        return "redirect:/book";
    }

    /**
     * 編集画面表示
     * 
     * @param model
     * @return
     */
    @GetMapping("/edit/{bookId}")
    public String displayEdit(@AuthenticationPrincipal LoginUserDetails user, @PathVariable Integer bookId,
            Model model) {
        Book book = bookService.findByBookId(user.getUserId(), bookId);
        model.addAttribute("bookRequest", book);
        return "book/edit";
    }

    /**
     * 編集画面の更新処理
     */
    @PutMapping("/edit")
    public String edit(@AuthenticationPrincipal LoginUserDetails user, @ModelAttribute @Valid BookRequest bookRequest,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "book/edit";
        }
        if (bookService.existBookId(user.getUserId(), bookRequest.getBookId())) {
            return "book/edit";
        }
        bookService.update(user.getUserId(), bookRequest.getBookId(), bookRequest.getBookName());
        return "redirect:/book";
    }
}