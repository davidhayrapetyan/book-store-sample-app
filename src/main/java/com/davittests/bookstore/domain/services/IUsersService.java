package com.davittests.bookstore.domain.services;

import com.davittests.bookstore.domain.models.UserDTO;

import org.springframework.data.domain.Pageable;
import java.util.List;

public interface IUsersService {
    List<UserDTO> getUsers(Pageable page);
}
