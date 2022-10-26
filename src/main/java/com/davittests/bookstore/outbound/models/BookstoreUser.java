package com.davittests.bookstore.outbound.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "users", schema = "public")
public class BookstoreUser {
    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "id")
    private String id;

    @Column(nullable = false, unique = true, name = "username")
    private String username;

    @Column(nullable = false, name = "password")
    private String password;

    @Column(nullable = false, name = "role")
    private String role;
}
