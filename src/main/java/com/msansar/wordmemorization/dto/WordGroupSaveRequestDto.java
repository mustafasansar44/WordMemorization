package com.msansar.wordmemorization.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class WordGroupSaveRequestDto {
    private String foreignWord;
    private String localWord;
    private boolean isActive;
    private String userId;
}
