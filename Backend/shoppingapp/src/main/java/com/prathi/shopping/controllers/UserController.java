package com.prathi.shopping.controllers;

//UserController.java
package com.prathi.shopping.controllers.controller;

import com.prathi.shopping.controllers.model.User;
import com.prathi.shopping.controllers.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

 private final UserRepository userRepository;

 @Autowired
 public UserController(UserRepository userRepository) {
     this.userRepository = userRepository;
 }

 @GetMapping
 public List<User> getAllUsers() {
     return userRepository.findAll();
 }

 @GetMapping("/{userId}")
 public User getUserById(@PathVariable Long userId) {
     return userRepository.findById(userId)
             .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
 }
}

