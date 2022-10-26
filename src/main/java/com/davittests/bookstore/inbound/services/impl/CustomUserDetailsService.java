package com.davittests.bookstore.inbound.services.impl;

import com.davittests.bookstore.inbound.services.IAuthenticationFacade;
import com.davittests.bookstore.outbound.models.BookstoreUser;
import com.davittests.bookstore.outbound.repositories.BookstoreUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private BookstoreUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final BookstoreUser bookstoreUser = userRepository.findByEmail(username);
        if (bookstoreUser == null) {
            throw new UsernameNotFoundException(username);
        }
        UserDetails user = User.withUsername(bookstoreUser.getEmail())
                .password(bookstoreUser.getPassword())
                .authorities(bookstoreUser.getRole())
                .build();
        return user;
    }
}
