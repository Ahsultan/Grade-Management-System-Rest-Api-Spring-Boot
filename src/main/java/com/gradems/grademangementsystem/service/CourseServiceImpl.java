package com.gradems.grademangementsystem.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.gradems.grademangementsystem.entity.Course;
import com.gradems.grademangementsystem.repository.CourseRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CourseServiceImpl implements CourseService {

    CourseRepository courseRepository;

    @Override
    public Course getCourse(UUID id) {
        return courseRepository.findById(id).get();
    }

    @Override
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public void deleteCourse(UUID id) {
        courseRepository.deleteById(id);
    }

    @Override
    public List<Course> getCourses() {
        return (List<Course>)courseRepository.findAll();
    }
    
}
