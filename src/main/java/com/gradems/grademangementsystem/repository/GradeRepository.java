package com.gradems.grademangementsystem.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import com.gradems.grademangementsystem.entity.Grade;

public interface GradeRepository extends CrudRepository<Grade, UUID> {

    Optional<Grade> findByStudentIdAndCourseId(UUID studentId, UUID courseId);

    void deleteByStudentIdAndCourseId(UUID studentId, UUID courseId);

    List<Grade> findByStudentId(UUID studentId);

    List<Grade> findByCourseId(UUID courseId);
    
}
