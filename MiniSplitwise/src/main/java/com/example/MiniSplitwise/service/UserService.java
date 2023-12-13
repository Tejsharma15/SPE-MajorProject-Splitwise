package com.example.MiniSplitwise.service;

import com.example.MiniSplitwise.dto.UserDTO;
import com.example.MiniSplitwise.model.User;
import com.example.MiniSplitwise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import  java.util.*;

@Service
public class UserService{
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UUID insertUser(UserDTO userDTO){
        User user = userDTO.getUserFromDto();
        return userRepository.save(user).getUserId();
    }

    public User updateUser(UUID id, User user) {
        user.setUserId(id);
        return userRepository.save(user);
    }
    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    public Optional<User> getUserById(UUID userId){
        return userRepository.findById(userId);
    }
}
