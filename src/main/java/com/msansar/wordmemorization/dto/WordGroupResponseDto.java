package com.msansar.wordmemorization.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class WordGroupResponseDto {
    private String id;
    private Date createdAt;
    private Date updatedAt;
    private String foreignWord;
    private String localWord;
    private boolean isActive;
}
