package com.davittests.bookstore.inbound.controllers;

import com.davittests.bookstore.domain.services.IAuthenticationFacade;
import com.davittests.bookstore.inbound.controllers.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BooksController {
    @Autowired
    private IAuthenticationFacade authenticationFacade;

    @RequestMapping(value = "/", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Book>> listUsers(@RequestParam("page") int page,
                         @RequestParam("size") int size) {
        var authentication = authenticationFacade.getAuthentication();
        if(!authentication.getAuthorities().contains(new SimpleGrantedAuthority("admin")) ||
                !authentication.getAuthorities().contains(new SimpleGrantedAuthority("author"))) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        System.out.println(page+":"+size);
        List<Book> books = new ArrayList<>();
        Book book = new Book();
        book.setTitle("aaa");
        book.setDescription("bbb");
        book.setAuthorId("ddd");
        book.setId("id");
        books.add(book);
        return ResponseEntity.ok(books);
    }
}
