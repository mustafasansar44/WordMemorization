package com.msansar.wordmemorization.controller;

import com.msansar.wordmemorization.service.WordGroupService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wordGroup")
public class WordGroupController {
    private final WordGroupService wordGroupService;

    public WordGroupController(WordGroupService wordGroupService) {
        this.wordGroupService = wordGroupService;
    }


}
