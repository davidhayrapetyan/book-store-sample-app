package com.davittests.bookstore.inbound.controllers.models;

import lombok.Data;

@Data
public class User {
    private String id;
    private String username;
    private String password;
    private String role;
}
