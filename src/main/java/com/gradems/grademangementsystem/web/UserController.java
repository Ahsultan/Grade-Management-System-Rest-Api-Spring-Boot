package com.gradems.grademangementsystem.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gradems.grademangementsystem.entity.User;
import com.gradems.grademangementsystem.service.UserService;

import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<String> getUser(@PathVariable String userId) {
        return ResponseEntity.ok().body(userService.getUserById(userId).getUsername());
    }

    @PostMapping("/register")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        //userService.saveUser(user);
        return  ResponseEntity.ok().body(userService.saveUser(user).getId());
    }
    
    
}
