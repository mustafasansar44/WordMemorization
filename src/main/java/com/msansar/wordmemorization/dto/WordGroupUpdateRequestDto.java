package com.msansar.wordmemorization.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class WordGroupUpdateRequestDto {
    private String id;
    private String foreignWord;
    private String localWord;
    private boolean isActive;
}
