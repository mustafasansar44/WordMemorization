package com.msansar.wordmemorization.controller;

import com.msansar.wordmemorization.dto.UserResponseDto;
import com.msansar.wordmemorization.dto.UserSaveRequestDto;
import com.msansar.wordmemorization.dto.UserUpdateRequestDto;
import com.msansar.wordmemorization.dto.WordGroupResponseDto;
import com.msansar.wordmemorization.dto.WordGroupSaveRequestDto;
import com.msansar.wordmemorization.dto.WordGroupUpdateRequestDto;
import com.msansar.wordmemorization.service.WordGroupService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/wordGroup")
public class WordGroupController {
    private final WordGroupService wordGroupService;

    public WordGroupController(WordGroupService wordGroupService) {
        this.wordGroupService = wordGroupService;
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<WordGroupResponseDto>> findAll(){
        return ResponseEntity.ok(wordGroupService.findAll());
    }
    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody WordGroupSaveRequestDto saveRequest){
        return ResponseEntity.ok(wordGroupService.save(saveRequest));
    }

    @PutMapping("/update")
    public String update(WordGroupUpdateRequestDto updateRequestDto){
        return wordGroupService.update(updateRequestDto);
    }

    @DeleteMapping("/delete")
    public String delete(String id){
        return wordGroupService.delete(id);
    }

}
