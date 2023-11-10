package com.msansar.wordmemorization.service;

import com.msansar.wordmemorization.model.User;
import com.msansar.wordmemorization.security.CustomUserDetail;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public CustomUserDetailsService(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public CustomUserDetail loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getEntityByUsername(username);
        return new CustomUserDetail(
                user.getUsername(),
                user.getPassword(),
                user.getRoles()
        );
    }

}
