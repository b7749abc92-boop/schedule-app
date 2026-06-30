package com.example.scheduleapp.dto;

import lombok.Getter;

@Getter
public class GetResponse {

    private final Long id;
    private final String title;
    private final String author;

    public GetResponse(Long id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }
}
