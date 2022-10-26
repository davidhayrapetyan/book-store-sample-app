package com.davittests.bookstore.domain.mappers;

import com.davittests.bookstore.domain.models.BookDTO;
import com.davittests.bookstore.domain.models.UserDTO;
import com.davittests.bookstore.outbound.models.Book;
import com.davittests.bookstore.outbound.models.BookstoreUser;

public final class BookstoreUserToDTOMapper {
    private BookstoreUserToDTOMapper(){};

    public static UserDTO mapFromBookstoreUser(final BookstoreUser bookstoreUser){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(bookstoreUser.getId());
        userDTO.setName(bookstoreUser.getName());
        userDTO.setEmail(bookstoreUser.getEmail());
        userDTO.setBirthdate(bookstoreUser.getBirthdate());
        userDTO.setRole(bookstoreUser.getRole());
        return userDTO;
    }
}
