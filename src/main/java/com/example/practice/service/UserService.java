package com.example.practice.service;

import com.example.practice.data.emp.UpdateUserEmailReq;
import com.example.practice.data.emp.User;
import com.example.practice.repo.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

//    public User updateUser(Long id, User userDetails) {
//        return userRepository.findById(id).map(user -> {
//            user.setName(userDetails.getName());
//            user.setEmail(userDetails.getEmail());
//            return userRepository.save(user);
//        }).orElse(null);
//    }

    @Transactional
    public User updateUser(Long id, User userDetails) {
        User user = userRepository.findById(id)
                                  .orElseThrow(() -> new RuntimeException("User not found"));
        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        // changes auto-flushed at transaction commit
        return user;
    }


    public ResponseEntity<String> updateUserEmail(Long id, UpdateUserEmailReq updateEmailReq) {
        return userRepository.findById(id).map(user -> {
            user.setEmail(updateEmailReq.getEmail());
            userRepository.save(user);
            return ResponseEntity.ok("Email updated successfully for user " + id);
        }).orElse(ResponseEntity.notFound().build());
    }

}

