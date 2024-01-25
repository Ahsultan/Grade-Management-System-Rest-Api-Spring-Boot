package com.gradems.grademangementsystem.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.gradems.grademangementsystem.entity.Student;

public interface StudentRepository extends CrudRepository<Student, UUID> {

    
}
