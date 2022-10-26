package com.davittests.bookstore.inbound.controllers;

import com.davittests.bookstore.domain.services.IAuthenticationFacade;
import com.davittests.bookstore.inbound.controllers.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    @Autowired
    private IAuthenticationFacade authenticationFacade;

    @RequestMapping(value = "/", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<User>> listUsers() {
        var authentication = authenticationFacade.getAuthentication();
        if(!authentication.getAuthorities().contains(new SimpleGrantedAuthority("admin"))) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        List<User> users = new ArrayList<>();
        User user = new User();
        user.setUsername("aaa");
        user.setPassword("bbb");
        user.setRole("ddd");
        user.setId("id");
        users.add(user);
        return ResponseEntity.ok(users);

    }
}
