package com.sparta.noticeboard.dto;

import lombok.Getter;

@Getter
public class PostRequestDto {
    private String author;
    private String contents;
    private String title;
    private String password;
}
