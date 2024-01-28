package com.gradems.grademangementsystem.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.gradems.grademangementsystem.entity.Course;
import com.gradems.grademangementsystem.entity.Grade;
import com.gradems.grademangementsystem.entity.Student;
import com.gradems.grademangementsystem.exception.NotFoundException;
import com.gradems.grademangementsystem.exception.StudentNotEnrolledException;
import com.gradems.grademangementsystem.repository.GradeRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class GradeServiceImpl implements GradeService {

    GradeRepository gradeRepository;
    StudentService studentService;
    CourseService courseService;

    @Override
    public Grade getGrade(UUID studentId, UUID courseId) {
        Optional<Grade> grade = gradeRepository.findByStudentIdAndCourseId(studentId, courseId);
        return unwrapGrade(grade, studentId, courseId);
    }

    @Override
    public Grade saveGrade(Grade grade, UUID studentId, UUID courseId) {
        Student student = studentService.getStudent(studentId);
        Course course = courseService.getCourse(courseId);
        // student.getCourses().contains(course);
        
        boolean isCourseEnrolled = student.getCourses().stream().anyMatch( c -> c.getId() == courseId);
        if(!isCourseEnrolled) throw new StudentNotEnrolledException(studentId, courseId);

        grade.setCourse(course);
        grade.setStudent(student);
        return gradeRepository.save(grade);
    }

    @Override
    public Grade updatGrade(String score, UUID studentId, UUID courseId) { 
        Grade grade = getGrade(studentId, courseId);
        grade.setScore(score);
        return gradeRepository.save(grade);
    }

    @Override
    public void deleteGrad(UUID studentId, UUID courseId) {
        if(getGrade(studentId, courseId) != null){
            gradeRepository.deleteByStudentIdAndCourseId(studentId, courseId);
        }
    }

    @Override
    public List<Grade> getStudentGrades(UUID studentId) {
        return  gradeRepository.findByStudentId(studentId);
    }

    @Override
    public List<Grade> getCourseGrades(UUID courseId) {
        return gradeRepository.findByCourseId(courseId);
    }

    @Override
    public List<Grade> getAllGrades() {
        return (List<Grade>)gradeRepository.findAll();
    }

    static Grade unwrapGrade(Optional<Grade> grade, UUID sid, UUID cid) {
        if(grade.isPresent()){
            return grade.get();
        } else {
            throw new NotFoundException(sid, cid);
        }
    }
    
}
