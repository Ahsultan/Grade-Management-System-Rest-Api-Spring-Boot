package com.gradems.grademangementsystem.service;

import java.util.List;
import java.util.UUID;

import com.gradems.grademangementsystem.entity.Grade;

public interface GradeService {
    Grade getGrade(UUID studentId, UUID CourseId);
    Grade saveGrade(Grade grade, UUID studentId, UUID courseId);
    Grade updatGrade(String score, UUID studentId, UUID courseId);
    void deleteGrad(UUID studentId, UUID courseId);
    List<Grade> getStudentGrades(UUID studentId);
    List<Grade> getCourseGrades(UUID courseId);
    List<Grade> getAllGrades();
}
