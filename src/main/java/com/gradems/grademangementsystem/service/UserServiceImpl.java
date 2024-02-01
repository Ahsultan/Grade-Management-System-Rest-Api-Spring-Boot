package com.gradems.grademangementsystem.service;

import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.gradems.grademangementsystem.entity.User;
import com.gradems.grademangementsystem.exception.EntityNotFoundException;
import com.gradems.grademangementsystem.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    UserRepository userRepository;
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User getUserById(String id) {
        return unwrapUser(userRepository.findById(id), id);
    }

    @Override
    public User getUserByUserName(String userName) {
        return unwrapUser(userRepository.findByUsername(userName), userName);
    }

    @Override
    public User saveUser(User user) {
        user.setPassWord(bCryptPasswordEncoder.encode(user.getPassWord()));
        return userRepository.save(user);
    }

    private User unwrapUser(Optional<User> user, String id) {
        if(user.isPresent()){
            return user.get();
        } else {
            throw new EntityNotFoundException(id, User.class);
        }
    }
}
