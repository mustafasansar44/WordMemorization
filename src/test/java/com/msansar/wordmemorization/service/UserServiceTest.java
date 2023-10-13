package com.msansar.wordmemorization.service;

import com.msansar.wordmemorization.dto.converter.UserDtoConverter;
import com.msansar.wordmemorization.exception.CustomDublicateKeyException;
import com.msansar.wordmemorization.exception.CustomNotFoundException;
import com.msansar.wordmemorization.model.User;
import com.msansar.wordmemorization.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;


// TODO: AOP ile file'dan alınabilir mi ?
// TODO: TEST METODLARININ ADLARINI DÜZELT


public class UserServiceTest {
    private UserRepository userRepository;
    private UserDtoConverter userDtoConverter;
    private UserService userService;

    @BeforeEach
    void setUp(){
        userRepository = mock(UserRepository.class);
        userDtoConverter = mock(UserDtoConverter.class);
        userService = new UserService(userRepository, userDtoConverter);
    }
    @Test
    public void testFindAll_shouldReturn20UserDtoList(){

    }

    @Test
    @DisplayName("findById() eğer id mevcutsa UserDto dönmeli ")
    public void testFindById_whenIdExists_shouldReturnUserResponseDto(){
    }

    @Test
    @DisplayName("findById() eğer id mevcut değilse CustomNotFoundException throw etmeli")
    public void testFindById_whenIdDoesNotExists_shouldReturnCustomNotFoundException(){
    }

    @Test
    @DisplayName("delete() eğer id mevcutsa silmeli ve bir mesaj döndürmeli")
    public void testDelete_whenIdExists_shouldDeleteUser(){
    }

    @Test
    @DisplayName("delete() eğer id mevcut değilse CustomNotFoundException throw etmeli")
    public void testDelete_whenIdDoesNotExists_shouldThrowCustomNotFoundException(){
    }

    @Test
    @DisplayName("save() user kaydedilirse geriye bir mesaj dönmeli")
    void testSave_whenNewUserIsSaved_ShouldReturnMessage(){
    }

    @Test
    @DisplayName("save() user zaten kayıtlıysa DublicateUserException throw etmeli")
    void testSave_WhenDuplicateUserIsSaved_ShouldThrowDuplicateUserException(){
    }

    @Test
    @DisplayName("update() user güncellenirse geriye bir mesaj dönmeli")
    void testUpdate_whenUpdatedUser_ShouldReturnMessage(){
    }

    @Test
    void testUpdate_whenUserDoesNotExist_ShouldReturnNotFoundException(){
    }

    @Test
    void testUpdate_whenDublicateUsernameAndPasswordExist_ShouldReturnDublicateKeyException(){
    }
}
