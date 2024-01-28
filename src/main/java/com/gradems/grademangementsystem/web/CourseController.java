package com.gradems.grademangementsystem.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gradems.grademangementsystem.entity.Course;
import com.gradems.grademangementsystem.entity.Student;
import com.gradems.grademangementsystem.service.CourseService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;




@AllArgsConstructor
@RestController
@RequestMapping("/course")
public class CourseController {

    CourseService courseService;

    @GetMapping("/student-enrolled/{courseId}")
    public ResponseEntity<List<Student>> getEnrolledStudents(@PathVariable UUID courseId) {
        return ResponseEntity.ok().body(courseService.getEnrolledStudents(courseId));
    }
    

    @PostMapping
    public ResponseEntity<Course> saveCourse(@RequestBody @Valid Course course) {
        return new ResponseEntity<>(courseService.saveCourse(course), HttpStatus.CREATED);
    }

    @PutMapping("/{id}/student/{sid}")
    public ResponseEntity<Course> enrollStudent(@PathVariable UUID id, @PathVariable UUID sid) {
        return ResponseEntity.ok().body(courseService.addStudentToCourse(id, sid));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourse(@PathVariable UUID id) {
        return new ResponseEntity<>(courseService.getCourse(id), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Course>> getCourses() {
        return new ResponseEntity<>(courseService.getCourses(), HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable UUID id) {
        courseService.deleteCourse(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    
    
    
}
