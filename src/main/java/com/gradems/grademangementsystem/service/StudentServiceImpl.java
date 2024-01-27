package com.gradems.grademangementsystem.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gradems.grademangementsystem.entity.Student;
import com.gradems.grademangementsystem.exception.NotFoundException;
import com.gradems.grademangementsystem.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public Student getStudent(UUID id) {
        Optional<Student> student = studentRepository.findById(id);
        return unwrapStudent(student, id);
    }

    @Override
    public Student saveStudent(Student student) {
         //TODO validation of entity or exception to be passed with proper status code
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(UUID id) {
        if(getStudent(id) != null){
            studentRepository.deleteById(id);
        }
    }

    @Override
    public List<Student> getStudents() {
        return (List<Student>)studentRepository.findAll();
    }

    static Student unwrapStudent(Optional<Student> student, UUID id) {
        if(student.isPresent()){
            return student.get();
        } else {
            throw new NotFoundException(id);
        }
    }
    
}
