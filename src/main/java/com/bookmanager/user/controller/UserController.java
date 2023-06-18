package com.bookmanager.user.controller;

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

import com.bookmanager.user.dto.UserRequest;
import com.bookmanager.user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 追加画面表示
     * 
     * @param model
     * @return
     */
    @GetMapping("/add")
    public String displayAdd(Model model) {
        UserRequest userRequest=new UserRequest();
        userRequest.setUserId(1);
        model.addAttribute("userRequest", userRequest);
        return "user/add";
    }

    /**
     * 追加
     * 
     * @param model
     * @return
     */
    @PostMapping
    public String add(@Validated @ModelAttribute UserRequest userRequest,
            BindingResult result,
            Model model) {
        if (result.hasErrors()) {
            // 入力チェックエラーの場合
            List<String> errorList = new ArrayList<String>();
            for (ObjectError error : result.getAllErrors()) {
                errorList.add(error.getDefaultMessage());
            }
            model.addAttribute("validationError", errorList);
            return "user/add";
        }
        if (userService.existUserId(userRequest.getUserId())) {
            List<String> errorList = new ArrayList<String>();
            errorList.add("userIdが既に存在します。");
            model.addAttribute("validationError", errorList);
            return "user/add";
        }
        if (!userRequest.getPassword().equals(userRequest.getPasswordCheck())) {
            List<String> errorList = new ArrayList<String>();
            errorList.add("パスワードとパスワード再入力の値が異なります。");
            model.addAttribute("validationError", errorList);
            return "user/add";
        }
        // ユーザの追加
        userService.add(userRequest.getUserId(),
                userRequest.getUserName(),
                userRequest.getPassword(),
                userRequest.getPasswordCheck());
        return "redirect:/login";
    }

}
