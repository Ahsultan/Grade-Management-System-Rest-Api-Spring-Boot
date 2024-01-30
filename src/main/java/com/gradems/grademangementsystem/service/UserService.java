package com.gradems.grademangementsystem.service;

import com.gradems.grademangementsystem.entity.User;

public interface UserService {
    User getUserById(String id);
    User getUserByUserName(String userName);
    User saveUser(User user);
}
