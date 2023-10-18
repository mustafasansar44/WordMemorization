package com.msansar.wordmemorization.dto.converter;

import com.msansar.wordmemorization.dto.WordGroupResponseDto;
import com.msansar.wordmemorization.model.WordGroup;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WordGroupDtoConverter {
    public WordGroupResponseDto convertToWordGroupResponseDto(WordGroup wordGroup){
        return new WordGroupResponseDto(
            wordGroup.getId(), wordGroup.getCreatedAt(), wordGroup.getUpdatedAt(), wordGroup.getForeignWord(), wordGroup.getLocalWord(), wordGroup.isActive()
        );
    }

    public List<WordGroupResponseDto> convertToWordGroupResponseDtoList(List<WordGroup> wordGroups){
        return wordGroups.stream().map(wordGroup -> convertToWordGroupResponseDto(wordGroup)).toList();
    }
}
