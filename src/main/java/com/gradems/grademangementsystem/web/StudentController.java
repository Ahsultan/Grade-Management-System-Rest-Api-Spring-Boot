package com.gradems.grademangementsystem.web;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.gradems.grademangementsystem.entity.Student;
import com.gradems.grademangementsystem.service.StudentService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable UUID id) {
        return new ResponseEntity<>(studentService.getStudent(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Student> postMethodName(@RequestBody Student student) {
        return new ResponseEntity<>(studentService.savStudent(student), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Student>> getMethodName(@RequestParam String param) {
        return new ResponseEntity<>(studentService.getStudents(), HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteStudent(@PathVariable UUID id) {
        studentService.deleteStudent(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    
}
