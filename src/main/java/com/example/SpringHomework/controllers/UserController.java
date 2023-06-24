package com.example.SpringHomework.controllers;

import com.example.SpringHomework.dtos.UserRequest;
import com.example.SpringHomework.dtos.UserResponse;
import com.example.SpringHomework.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="api/v1/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping(path = "/register")
    public ResponseEntity<UserResponse> registerUser(@Valid @RequestBody UserRequest request) {
        UserResponse response = userService.saveUser(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    @GetMapping(path = "/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.FOUND)
                .body(userService.getUser(id));
    }

    @DeleteMapping(path = "/{id}")
    public HttpStatus deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return HttpStatus.ACCEPTED;
    }
}
