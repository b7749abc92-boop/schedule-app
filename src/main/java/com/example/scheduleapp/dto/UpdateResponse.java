package com.example.scheduleapp.dto;

import lombok.Getter;

@Getter
public class UpdateResponse {

    private final String title;
    private final String author;

    public UpdateResponse(String title, String author) {
        this.title = title;
        this.author = author;
    }
}
