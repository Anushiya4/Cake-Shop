package com.example.cake.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cake.entity.UserEntity;
import com.example.cake.model.User;
import com.example.cake.service.UserService;

@RestController
@CrossOrigin(origins = "*")
public class UserController {
	
	@Autowired
    private UserService userService;

    @PostMapping("/user/register")
    public ResponseEntity<String> registerUser(@RequestBody UserEntity user) {
        // Save user to the database
    	userService.saveUser(user);
        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody User user) {
    	Long userId = userService.login(user);
    	if (userId != null) {
    		return new ResponseEntity<>(userId, HttpStatus.OK);
    	}  else {
    		return new ResponseEntity<>("Wrong crendials", HttpStatus.BAD_REQUEST);
    	}
    }
    
    @GetMapping("/user/{userId}")
    public User registerUser(@PathVariable Long userId) {
    	return userService.getUser(userId);
    }
    
    @PostMapping("/user/update")
    public ResponseEntity<String> updateUser(@RequestBody User user) {
    	userService.updateUser(user);
        return new ResponseEntity<>("User updated successfully", HttpStatus.OK);
    }
	
}
