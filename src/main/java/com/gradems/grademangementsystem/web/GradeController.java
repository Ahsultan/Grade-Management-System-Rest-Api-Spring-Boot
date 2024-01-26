package com.gradems.grademangementsystem.web;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gradems.grademangementsystem.entity.Grade;
import com.gradems.grademangementsystem.service.GradeService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
@RequestMapping("/grade")
public class GradeController {

    @Autowired
    GradeService gradeService;

    @GetMapping("/all")
    public ResponseEntity<List<Grade>> getGrades() {
        return new ResponseEntity<>(gradeService.getAllGrades(), HttpStatus.OK);
    }
    

    @GetMapping("/{studentId}/course/{courseId}")
    public ResponseEntity<Grade> getGrade(@PathVariable UUID studentId, @PathVariable UUID courseId) {
        return new ResponseEntity<>(gradeService.getGrade(studentId, courseId), HttpStatus.OK);
    }

    @PostMapping("/{studentId}/course/{courseId}")
    public ResponseEntity<Grade> saveGrade(@RequestBody Grade grade, @PathVariable UUID studentId, @PathVariable UUID courseId) {
        return new ResponseEntity<>(gradeService.savGrade(grade, studentId, courseId), HttpStatus.CREATED);
    }

    @PutMapping("student/{studentId}/course/{courseId}")
    public ResponseEntity<Grade> updateGrade(@RequestBody String score, @PathVariable UUID studentId, @PathVariable UUID courseId) {
        return new ResponseEntity<>(gradeService.updatGrade(score, studentId, courseId), HttpStatus.CREATED);
    }

    @GetMapping("student/{studentId}")
    public ResponseEntity<List<Grade>> getGradesByStudent(@PathVariable UUID studentId) {
        return new ResponseEntity<>(gradeService.getStudentGrades(studentId), HttpStatus.OK);
    }

    @GetMapping("course/{courseId}")
    public ResponseEntity<List<Grade>> getGradesByCourse(@PathVariable UUID courseId) {
        return new ResponseEntity<>(gradeService.getCourseGrades(courseId), HttpStatus.OK);
    }
    
    @DeleteMapping("student/{studentId}/course/{courseId}")
    public HttpStatus deleteGrade(@PathVariable UUID studentId, @PathVariable UUID courseId) {
        gradeService.deleteGrad(studentId, courseId);
        return HttpStatus.OK;
    }
    
    
}
