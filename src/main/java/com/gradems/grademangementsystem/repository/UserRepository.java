package com.gradems.grademangementsystem.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.gradems.grademangementsystem.entity.User;

public interface UserRepository extends CrudRepository<User, String> {
    Optional<User> findByUsername(String username);
}
