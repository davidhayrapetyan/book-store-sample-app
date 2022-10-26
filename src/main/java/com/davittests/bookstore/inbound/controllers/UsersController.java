package com.davittests.bookstore.inbound.controllers;

import com.davittests.bookstore.domain.models.UserDTO;
import com.davittests.bookstore.domain.services.impl.UsersService;
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

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    @Autowired
    private IAuthenticationFacade authenticationFacade;

    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<UserDTO>> listUsers(@RequestParam("page") int page,
                                                @RequestParam("size") int size) {
        var authentication = authenticationFacade.getAuthentication();
        if(!authentication.getAuthorities().contains(new SimpleGrantedAuthority("admin"))) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        List<UserDTO> users = usersService.getUsers(PageRequest.of(page, size));
        return ResponseEntity.ok(users);

    }
}
