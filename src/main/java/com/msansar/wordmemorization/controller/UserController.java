package com.msansar.wordmemorization.controller;

import com.msansar.wordmemorization.dto.UserLoginRequestDto;
import com.msansar.wordmemorization.dto.UserResponseDto;
import com.msansar.wordmemorization.dto.UserSaveRequestDto;
import com.msansar.wordmemorization.dto.UserUpdateRequestDto;
import com.msansar.wordmemorization.model.User;
import com.msansar.wordmemorization.service.UserService;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin (origins = "*" , exposedHeaders = "**")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<UserResponseDto>> findAll(){
        return ResponseEntity.ok(userService.findAll());
    }
    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody UserSaveRequestDto saveRequestDto){
        return ResponseEntity.ok(userService.save(saveRequestDto));
    }

    @PutMapping("/update")
    public String update(UserUpdateRequestDto updateRequestDto){
        return userService.update(updateRequestDto);
    }

    @DeleteMapping("/delete")
    public String delete(String id){
        return userService.delete(id);
    }

//    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    @GetMapping("/user")
    public String user(){
        return "USER";
    }

//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/admin")
    public String admin(){
        return "ADMIN";
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserLoginRequestDto loginRequestDto){
        return ResponseEntity.ok(userService.login(loginRequestDto));
    }
    @PostMapping("/test-request")
    public ResponseEntity<String> testPostRequest() {
        return ResponseEntity.ok("POST request successful");
    }
}
