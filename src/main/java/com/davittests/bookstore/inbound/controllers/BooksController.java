package com.davittests.bookstore.inbound.controllers;

import com.davittests.bookstore.domain.models.BookDTO;
import com.davittests.bookstore.domain.services.impl.BooksService;
import com.davittests.bookstore.inbound.services.IAuthenticationFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BooksController {
    @Autowired
    private IAuthenticationFacade authenticationFacade;

    @Autowired
    private BooksService booksService;

    @RequestMapping(value = "/", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<BookDTO>> listUsers(@RequestParam("page") int page,
                                                   @RequestParam("size") int size) {
        var authentication = authenticationFacade.getAuthentication();
        if(!authentication.getAuthorities().contains(new SimpleGrantedAuthority("admin")) &&
                !authentication.getAuthorities().contains(new SimpleGrantedAuthority("author"))) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        List<BookDTO> books = booksService.getAllBooks(PageRequest.of(page, size));
        return ResponseEntity.ok(books);
    }
}
