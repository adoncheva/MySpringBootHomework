package com.example.SpringHomework.services;

import com.example.SpringHomework.dtos.UserRequest;
import com.example.SpringHomework.dtos.UserResponse;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UserResponse saveUser(UserRequest userRequest);

    UserResponse getUser(Long id);

    void deleteUser(Long id);
}
