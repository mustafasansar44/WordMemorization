package com.msansar.wordmemorization.service;



import com.msansar.wordmemorization.dto.UserResponseDto;
import com.msansar.wordmemorization.dto.UserSaveRequestDto;
import com.msansar.wordmemorization.dto.UserUpdateRequestDto;
import com.msansar.wordmemorization.dto.converter.UserDtoConverter;
import com.msansar.wordmemorization.exception.CustomNotFoundException;
import com.msansar.wordmemorization.model.User;
import com.msansar.wordmemorization.repository.UserRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService{
    private final UserRepository userRepository;
    private final UserDtoConverter userDtoConverter;

    public UserService(UserRepository userRepository, UserDtoConverter userDtoConverter) {
        this.userRepository = userRepository;
        this.userDtoConverter = userDtoConverter;
    }

    public List<UserResponseDto> findAll(){
        Pageable firstPageWithTwoElements = PageRequest.of(0, 10);
        List<User> users = userRepository.findAll(firstPageWithTwoElements).toList();
        return userDtoConverter.convertToUserResponseDtoList(users);
    }
    public String save(UserSaveRequestDto saveRequestDto){
        userRepository.save(new User(
                saveRequestDto.getUsername(), saveRequestDto.getPassword(), saveRequestDto.getEmail()
        ));
        return "Kullanıcı Kaydedildi!";
    }
    public String update(UserUpdateRequestDto updatedRequestDto) {
        User user = getEntityById(updatedRequestDto.getId());
        user.setUsername(updatedRequestDto.getUsername());
        user.setPassword(updatedRequestDto.getPassword());
        user.setEmail(updatedRequestDto.getEmail());
        userRepository.save(user);
        return "Kullanıcı Güncellendi!";
    }

    public String delete(String id){
        userRepository.delete(getEntityById(id));
        return "Kullanıcı Silindi!";
    }

    protected User getEntityById(String id){
        return userRepository.findById(id).orElseThrow(
                () -> new CustomNotFoundException("Kullanıcı Bulunamadı!")
        );
    }
}
