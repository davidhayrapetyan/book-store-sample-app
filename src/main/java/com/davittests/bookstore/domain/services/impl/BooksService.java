package com.davittests.bookstore.domain.services.impl;

import com.davittests.bookstore.domain.mappers.BookToDTOMapper;
import com.davittests.bookstore.domain.models.BookDTO;
import com.davittests.bookstore.domain.models.UserDTO;
import com.davittests.bookstore.domain.services.IBooksService;
import com.davittests.bookstore.outbound.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class BooksService implements IBooksService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<BookDTO> getAllBooks(final Pageable page) {
        List<BookDTO> bookDTOS = new LinkedList<>();
        bookRepository.findAll(page).forEach(book ->
        {
            bookDTOS.add(BookToDTOMapper.mapFromBook(book));
        });
        return bookDTOS;
    }
}
