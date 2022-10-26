package com.davittests.bookstore.domain.models;

import com.davittests.bookstore.outbound.models.BookstoreUser;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.sql.Date;

@Data
public class BookDTO {
    private String id;

    private UserDTO author;

    private String title;

    private String description;

    private Double price;

    private Date publishDate;
}
