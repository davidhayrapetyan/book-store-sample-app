package com.davittests.bookstore.outbound.repositories;

import com.davittests.bookstore.outbound.models.BookstoreUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookstoreUserRepository extends JpaRepository<BookstoreUser, String> {

    BookstoreUser findByUsername(String username);
}

