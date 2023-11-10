package com.msansar.wordmemorization.service;



import com.msansar.wordmemorization.dto.UserLoginRequestDto;
import com.msansar.wordmemorization.dto.UserResponseDto;
import com.msansar.wordmemorization.dto.UserSaveRequestDto;
import com.msansar.wordmemorization.dto.UserUpdateRequestDto;
import com.msansar.wordmemorization.dto.converter.UserDtoConverter;
import com.msansar.wordmemorization.exception.CustomNotFoundException;
import com.msansar.wordmemorization.model.User;
import com.msansar.wordmemorization.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Transactional
public class UserService{
    private final UserRepository userRepository;
    private final UserDtoConverter userDtoConverter;
    private BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository,
                       UserDtoConverter userDtoConverter,
                       BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userDtoConverter = userDtoConverter;
        this.passwordEncoder = passwordEncoder;
    }

    public List<UserResponseDto> findAll(){
        Pageable firstPageWithTwoElements = PageRequest.of(0, 10);
        List<User> users = userRepository.findAll(firstPageWithTwoElements).toList();
        return userDtoConverter.convertToUserResponseDtoList(users);
    }
    public String save(UserSaveRequestDto saveRequestDto){
        String bcryptPassword = passwordEncoder.encode(saveRequestDto.getPassword());
        userRepository.save(
                new User(saveRequestDto.getUsername(), bcryptPassword, saveRequestDto.getEmail())
        );
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

    public String login(UserLoginRequestDto loginRequestDto){
        return "LOGIN SAYFASI";
    }
    public UserResponseDto findByUsername(String username){
       User user = userRepository.findUserByUsername(username).orElseThrow(
               () -> new CustomNotFoundException("Kullanıcı Bulunamadı!")
       );
        return userDtoConverter.convertToUserResponseDto(user);
    }

    protected User getEntityById(String id){
        return userRepository.findById(id).orElseThrow(
                () -> new CustomNotFoundException("Kullanıcı Bulunamadı!")
        );
    }
    protected User getEntityByUsername(String username){
        return userRepository.findUserByUsername(username).orElseThrow(
                () -> new CustomNotFoundException("Kullanıcı Bulunamadı!")
        );
    }
}
