package com.msansar.wordmemorization.service;

import com.msansar.wordmemorization.dto.WordGroupResponseDto;
import com.msansar.wordmemorization.dto.WordGroupSaveRequestDto;
import com.msansar.wordmemorization.dto.WordGroupUpdateRequestDto;
import com.msansar.wordmemorization.dto.converter.WordGroupDtoConverter;
import com.msansar.wordmemorization.exception.CustomNotFoundException;
import com.msansar.wordmemorization.model.WordGroup;
import com.msansar.wordmemorization.repository.WordGroupRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordGroupService {

    private final WordGroupRepository wordGroupRepository;
    private final UserService userService;
    private final WordGroupDtoConverter wordGroupDtoConverter;
    public WordGroupService(WordGroupRepository wordGroupRepository, UserService userService, WordGroupDtoConverter wordGroupDtoConverter) {
        this.wordGroupRepository = wordGroupRepository;
        this.userService = userService;
        this.wordGroupDtoConverter = wordGroupDtoConverter;
    }

    public List<WordGroupResponseDto> findAll(){
        Pageable firstPageWithTwoElements = PageRequest.of(0, 10);
        List<WordGroup> wordGroupList = wordGroupRepository.findAll(firstPageWithTwoElements).toList();
        return wordGroupDtoConverter.convertToWordGroupResponseDtoList(wordGroupList);
    }

    public String save(WordGroupSaveRequestDto saveRequest){
        wordGroupRepository.save(
                new WordGroup(
                        saveRequest.getForeignWord(),
                        saveRequest.getLocalWord(),
                        saveRequest.isActive(),
                        userService.getEntityById(saveRequest.getUserId()))
        );
        return "Kelime Grubu Kaydedildi";
    }
    public String update(WordGroupUpdateRequestDto wordGroupUpdateRequestDto) {
        WordGroup wordGroup = getEntityById(wordGroupUpdateRequestDto.getId());
        wordGroup.setForeignWord(wordGroupUpdateRequestDto.getForeignWord());
        wordGroup.setLocalWord(wordGroupUpdateRequestDto.getLocalWord());
        wordGroup.setActive(wordGroupUpdateRequestDto.isActive());
        wordGroupRepository.save(wordGroup);
        return "Kelime Grubu Güncellendi!";
    }

    public String delete(String id){
        wordGroupRepository.delete(getEntityById(id));
        return "Kelime Grubu Silindi!";
    }

    protected WordGroup getEntityById(String id){
        return wordGroupRepository.findById(id).orElseThrow(
                () -> new CustomNotFoundException("Kelime Grubu Bulunamadı!")
        );
    }

}
