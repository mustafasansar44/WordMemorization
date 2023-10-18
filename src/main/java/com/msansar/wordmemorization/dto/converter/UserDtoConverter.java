package com.msansar.wordmemorization.dto.converter;

import com.msansar.wordmemorization.dto.UserOfWordGroupSaveDto;
import com.msansar.wordmemorization.dto.UserResponseDto;
import com.msansar.wordmemorization.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDtoConverter {
    private final WordGroupDtoConverter wordGroupDtoConverter;

    public UserDtoConverter(WordGroupDtoConverter wordGroupDtoConverter) {
        this.wordGroupDtoConverter = wordGroupDtoConverter;
    }
    public UserResponseDto convertToUserResponseDto(User user){
        return new UserResponseDto(
                user.getId(),
                user.getCreatedAt(),
                user.getUpdatedAt(),
                user.getUsername(),
                user.getPassword(),
                user.getEmail(),
                wordGroupDtoConverter.convertToWordGroupResponseDtoList(user.getWordGroupList())
        );
    }

    // TODO: Bunu daha sonra silmeli miyim ?
    public List<UserResponseDto> convertToUserResponseDtoList(List<User> users){
        return users.stream().map(user -> convertToUserResponseDto(user)).toList();
    }

    public UserOfWordGroupSaveDto convertToUserOfWordGroupSaveDto(User user){
        return new UserOfWordGroupSaveDto(
          user.getId(),
          user.getUsername(),
          user.getPassword(),
          user.getEmail()
        );
    }

}
