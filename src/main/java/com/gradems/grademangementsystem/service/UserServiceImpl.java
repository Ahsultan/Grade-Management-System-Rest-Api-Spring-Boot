package com.gradems.grademangementsystem.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.gradems.grademangementsystem.entity.User;
import com.gradems.grademangementsystem.exception.NotFoundException;
import com.gradems.grademangementsystem.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    @Override
    public User getUserById(String id) {
        return unwrapUser(userRepository.findById(id), id);
    }

    @Override
    public User getUserByUserName(String userName) {
        return unwrapUser(userRepository.findByUserName(userName), userName);
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    private User unwrapUser(Optional<User> user, String id) {
        if(user.isPresent()){
            return user.get();
        } else {
            throw new RuntimeException();
        }
    }
}
