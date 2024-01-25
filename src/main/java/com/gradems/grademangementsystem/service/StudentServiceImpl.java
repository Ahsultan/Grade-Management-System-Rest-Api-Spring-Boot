package com.gradems.grademangementsystem.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gradems.grademangementsystem.entity.Student;
import com.gradems.grademangementsystem.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public Student getStudent(UUID id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public Student savStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(UUID id) {
        studentRepository.deleteById(id);
    }

    @Override
    public List<Student> getStudents() {
        return (List<Student>)studentRepository.findAll();
    }
    
}
