package com.davittests.bookstore.domain.services;

import com.davittests.bookstore.domain.models.BookDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBooksService {
    List<BookDTO> getAllBooks(Pageable page);
}
