package com.msansar.wordmemorization.service;



import com.msansar.wordmemorization.dto.converter.UserDtoConverter;
import com.msansar.wordmemorization.repository.UserRepository;
import org.springframework.stereotype.Service;



@Service
public class UserService{
    private final UserRepository userRepository;
    private final UserDtoConverter userDtoConverter;

    public UserService(UserRepository userRepository, UserDtoConverter userDtoConverter) {
        this.userRepository = userRepository;
        this.userDtoConverter = userDtoConverter;
    }
}
