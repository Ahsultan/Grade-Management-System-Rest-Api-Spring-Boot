package com.gradems.grademangementsystem.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gradems.grademangementsystem.entity.Grade;
import com.gradems.grademangementsystem.repository.GradeRepository;

@Service
public class GradeServiceImpl implements GradeService {

    @Autowired
    GradeRepository gradeRepository;

    @Override
    public Grade getGrade(UUID studentId, UUID CourseId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getGrade'");
    }

    @Override
    public Grade savGrade(Grade grade, UUID studentId, UUID courseId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'savGrade'");
    }

    @Override
    public Grade updatGrade(String score, UUID studentId, UUID courseId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updatGrade'");
    }

    @Override
    public void deleteGrad(UUID studentId, UUID courseId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteGrad'");
    }

    @Override
    public List<Grade> getStudentGrades(UUID studentId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getStudentGrades'");
    }

    @Override
    public List<Grade> getCourseGrades(UUID courseId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCourseGrades'");
    }

    @Override
    public List<Grade> getAllGrades() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllGrades'");
    }
    
}
