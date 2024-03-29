package com.gradems.grademangementsystem.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.gradems.grademangementsystem.entity.Course;
import com.gradems.grademangementsystem.entity.Student;
import com.gradems.grademangementsystem.exception.NotFoundException;
import com.gradems.grademangementsystem.repository.CourseRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CourseServiceImpl implements CourseService {

    CourseRepository courseRepository;
    StudentService studentService;

    @Override
    public Course getCourse(UUID id) {
        Optional<Course> course =  courseRepository.findById(id);
        return unwrapCourse(course, id);
    }

    @Override
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public void deleteCourse(UUID id) {
        if(getCourse(id) !=  null) {
            courseRepository.deleteById(id);
        }
    }

    @Override
    public List<Course> getCourses() {
        return (List<Course>)courseRepository.findAll();
    }

    @Override
    public Course addStudentToCourse(UUID courseId, UUID studentId) {
        Student student = studentService.getStudent(studentId);
        Course course = getCourse(courseId);
        course.getStudents().add(student);
        return courseRepository.save(course);
    }

    @Override
    public List<Student> getEnrolledStudents(UUID courseId) {
        Optional<Course> course = courseRepository.findById(courseId);
        return unwrapCourse(course, courseId).getStudents().stream().toList();
    }

    private Course unwrapCourse(Optional<Course> course, UUID id) {
        if(course.isPresent()){
            return course.get();
        } else {
            throw new NotFoundException(id);
        }
    }
}
