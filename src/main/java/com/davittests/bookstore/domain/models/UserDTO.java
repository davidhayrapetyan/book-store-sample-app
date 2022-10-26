package com.davittests.bookstore.domain.models;

import lombok.Data;

import java.sql.Date;

@Data
public class UserDTO {
    private String id;

    private String email;

    private String name;

    private Date birthdate;

    private String password;

    private String role;
}
