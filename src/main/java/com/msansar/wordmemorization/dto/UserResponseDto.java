package com.msansar.wordmemorization.dto;

import com.msansar.wordmemorization.model.Role;
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


    private List<Role> authorities;
    public UserResponseDto(String id, Date createdAt, Date updatedAt, String username, String password, String email, List<WordGroupResponseDto> wordGroupList) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.username = username;
        this.password = password;
        this.email = email;
        this.wordGroupList = wordGroupList;
    }


}
