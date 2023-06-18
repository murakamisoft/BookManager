package com.bookmanager.user.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserRequest {

    @Min(1)
    @Max(9999)
    private Integer userId;

    @NotEmpty(message = "ユーザ名を入力してください")
    @Size(max = 255, message = "ユーザ名は255文字以内で入力してください")
    private String userName;

    @NotEmpty(message = "パスワードを入力してください")
    @Size(max = 255, message = "パスワードは255文字以内で入力してください")
    private String password;

    @NotEmpty(message = "パスワード再入力を入力してください")
    @Size(max = 255, message = "パスワード再入力は255文字以内で入力してください")
    private String passwordCheck;
}
