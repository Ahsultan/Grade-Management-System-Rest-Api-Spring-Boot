package com.gradems.grademangementsystem.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.gradems.grademangementsystem.entity.Grade;

public interface GradeRepository extends CrudRepository<Grade, UUID> {
    
}
