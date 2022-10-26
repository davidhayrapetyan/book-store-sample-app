package com.davittests.bookstore.outbound.repositories;

import com.davittests.bookstore.outbound.models.BookstoreUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.awt.print.Pageable;
import java.util.List;

public interface BookstoreUserRepository extends PagingAndSortingRepository<BookstoreUser, String> {

    BookstoreUser findByEmail(String email);

    @Query(
            value = "SELECT u.id, u.name, u.password, u.email, u.birthdate FROM BookstoreUser u ORDER BY u.id")
    List<BookstoreUser> findAll(Pageable pageable);
}

