package com.msansar.wordmemorization.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserOfWordGroupSaveDto {
    private String id;
    private String username;
    private String password;
    private String email;
}
