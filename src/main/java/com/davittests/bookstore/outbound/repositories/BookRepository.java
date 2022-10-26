package com.davittests.bookstore.outbound.repositories;

import com.davittests.bookstore.outbound.models.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.awt.print.Pageable;
import java.util.List;

public interface BookRepository extends PagingAndSortingRepository<Book, String> {
    @Query(
            value = "SELECT b.id, b.title, b.description, b.publishDate, b.price, b.author FROM Book b ORDER BY b.id")
    List<Book> findAll(Pageable pageable);
}
