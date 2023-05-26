package com.bookmanager.book.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * 本のリクエスト
 */
@Data
public class BookRequest {

    @NotNull(message = "本のIDを入力してください")
    private Integer bookId;
    
    /**
     * 名前
     */
    @NotEmpty(message = "名前を入力してください")
    @Size(max = 512, message = "名前は512文字以内で入力してください")
    private String bookName;

}
