package com.davittests.bookstore.domain.mappers;

import com.davittests.bookstore.domain.models.BookDTO;
import com.davittests.bookstore.outbound.models.Book;

public final class BookToDTOMapper {
    private BookToDTOMapper(){};

    public static BookDTO mapFromBook(final Book book){
        BookDTO bookDTO = new BookDTO();
        bookDTO.setAuthor(BookstoreUserToDTOMapper.mapFromBookstoreUser(book.getAuthor()));
        bookDTO.setId(book.getId());
        bookDTO.setPrice(book.getPrice());
        bookDTO.setTitle(book.getTitle());
        bookDTO.setDescription(book.getDescription());
        bookDTO.setPublishDate(book.getPublishDate());
        return bookDTO;
    }
}
