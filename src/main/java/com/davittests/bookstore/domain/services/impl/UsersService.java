package com.davittests.bookstore.domain.services.impl;

import com.davittests.bookstore.domain.mappers.BookstoreUserToDTOMapper;
import com.davittests.bookstore.domain.models.UserDTO;
import com.davittests.bookstore.domain.services.IUsersService;
import com.davittests.bookstore.outbound.repositories.BookstoreUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import java.util.LinkedList;
import java.util.List;

@Service
public class UsersService implements IUsersService {
    @Autowired
    private BookstoreUserRepository bookstoreUserRepository;

    @Override
    public List<UserDTO> getUsers(final Pageable page) {
        List<UserDTO> userDTOs = new LinkedList<>();
        bookstoreUserRepository.findAll(page).forEach(bookstoreUser ->
        {
            userDTOs.add(BookstoreUserToDTOMapper.mapFromBookstoreUser(bookstoreUser));
        });
        return userDTOs;
    }
}
