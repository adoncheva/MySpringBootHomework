package com.example.SpringHomework.services.implementation;

import com.example.SpringHomework.convertors.UserConverter;
import com.example.SpringHomework.dtos.UserRequest;
import com.example.SpringHomework.dtos.UserResponse;
import com.example.SpringHomework.entities.User;
import com.example.SpringHomework.repositories.UserRepository;
import com.example.SpringHomework.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplementation implements UserService {
    private final UserRepository userRepository;
    private final UserConverter userConverter;
@Autowired
    public UserServiceImplementation(UserRepository userRepository, UserConverter userConverter) {
        this.userRepository = userRepository;
        this.userConverter = userConverter;
    }

    @Override
    public UserResponse saveUser(UserRequest userRequest) {
        User user=userConverter.toUser(userRequest);
        User savedUser= userRepository.save(user);
        return userConverter.toResponse(savedUser);
    }

    @Override
    public UserResponse getUser(Long id) {
       User searchedUser=userRepository.findById(id).orElseThrow();
       return userConverter.toResponse(searchedUser);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
