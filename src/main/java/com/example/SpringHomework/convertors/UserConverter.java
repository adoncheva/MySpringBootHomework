package com.example.SpringHomework.convertors;

import com.example.SpringHomework.dtos.UserRequest;
import com.example.SpringHomework.dtos.UserResponse;
import com.example.SpringHomework.entities.User;
import org.springframework.stereotype.Component;

@Component

public class UserConverter {
public User toUser(UserRequest userRequest){
return User.builder()
        .firstName(userRequest.getFirstName())
        .lastName(userRequest.getLastName())
        .email(userRequest.getEmail())
        .password(userRequest.getPassword())
        .build();
}
    public UserResponse toResponse(User savedUser){
        return new UserResponse(
                savedUser.getEmail(),
                savedUser.getFirstName(),
                savedUser.getLastName());
    }
}
