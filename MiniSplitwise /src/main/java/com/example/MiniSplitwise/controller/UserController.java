package com.example.MiniSplitwise.controller;

import com.example.MiniSplitwise.service.UserService;
import com.example.MiniSplitwise.dto.UserDTO;
import com.example.MiniSplitwise.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.io.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }
    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        System.out.println("Return all users");
        try {
            List<User> users = userService.getAllUsers();

            if (users != null) {
                return ResponseEntity.ok(users);
            } else {
                // Handle the case where the list is null
                System.out.println("User list is null");
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        } catch (Exception e) {
            // Log the exception or handle it as needed
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") UUID id){
        System.out.println("Running find user by ID");
        Optional<User> userOptional = userService.getUserById(id);

        // Check if user exists
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return ResponseEntity.ok(user);
        } else {
            // Return a 404 Not Found response if user is not present
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public UUID insertUser(@RequestBody UserDTO userDTO){
        System.out.println("Running insert user");
        return userService.insertUser(userDTO);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable("id") UUID id){
        System.out.println("Running delete user by id");
        System.out.println(id);
        userService.deleteUser(id);
    }
}
