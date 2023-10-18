package com.msansar.wordmemorization.dto;

import com.msansar.wordmemorization.model.WordGroup;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserResponseDto {
    private String id;
    private Date createdAt;
    private Date updatedAt;
    private String username;
    private String password;
    private String email;
    List<WordGroupResponseDto> wordGroupList;
}
