package com.davittests.bookstore.inbound.controllers.models;

import lombok.Data;

@Data
public class Book {
    private String id;
    private String title;
    private String description;
    private String authorId;
}
