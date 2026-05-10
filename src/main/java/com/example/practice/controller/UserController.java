package com.example.practice.controller;

import com.example.practice.data.emp.UpdateUserEmailReq;
import com.example.practice.data.emp.User;
import com.example.practice.service.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody User user) {
        userService.saveUser(user);
        return ResponseEntity.ok("User created successfully");
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // ✅ GET - fetch user by ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        User updatedUser = userService.updateUser(id, userDetails);
        if (updatedUser != null) {
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/email")
    public ResponseEntity<String> updateUserEmail(
            @RequestHeader Long userId,
            @RequestBody @Valid UpdateUserEmailReq updateUserEmailReq) {
        log.info("UserController --> updateUserEmail()");
        return userService.updateUserEmail(userId, updateUserEmailReq);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        boolean deleted = userService.deleteUser(id);
        if (deleted) {
            return ResponseEntity.ok("User deleted successfully with ID " + id);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}

