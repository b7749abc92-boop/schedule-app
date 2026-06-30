package com.example.scheduleapp.dto;

import lombok.Getter;

@Getter
public class CreateRequest {


    private String title;
    private String content;
    private String author;
    private String password;

}
