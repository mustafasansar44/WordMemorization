package com.msansar.wordmemorization.dto;

import com.msansar.wordmemorization.model.WordGroup;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserSaveRequestDto {
    private String username;
    private String password;
    private String email;
}


// TODO: Kısıtlamaları yap! @Max @Min vs