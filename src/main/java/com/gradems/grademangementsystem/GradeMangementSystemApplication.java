package com.gradems.grademangementsystem;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gradems.grademangementsystem.entity.Course;
import com.gradems.grademangementsystem.entity.Student;
import com.gradems.grademangementsystem.repository.CourseRepository;
import com.gradems.grademangementsystem.repository.GradeRepository;
import com.gradems.grademangementsystem.repository.StudentRepository;

@SpringBootApplication
public class GradeMangementSystemApplication implements CommandLineRunner {

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	GradeRepository gradeRepository;

	@Autowired
	CourseRepository courseRepository;


	public static void main(String[] args) {
		SpringApplication.run(GradeMangementSystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Student[] students = new Student[] {
            new Student("Harry Potter", LocalDate.parse(("1980-07-31"))),
            new Student("Ron Weasley", LocalDate.parse(("1980-03-01"))),
            new Student("Hermione Granger", LocalDate.parse(("1979-09-19"))),
            new Student("Neville Longbottom", LocalDate.parse(("1980-07-30"))) 
        };
		
		for (int i = 0; i < students.length; i++) {
			studentRepository.save(students[i]);
		}

		Course[] courses = new Course[] {
            new Course("Charms", "CH104", "In this class, you will learn spells concerned with giving an object new and unexpected properties."),
            new Course("Defence Against the Dark Arts", "DADA", "In this class, you will learn defensive techniques against the dark arts."),
            new Course("Herbology", "HB311", "In this class, you will learn the study of magical plants and how to take care of, utilise and combat them."),
            new Course("History of Magic", "HIS393", "In this class, you will learn about significant events in wizarding history."),
            new Course("Potions", "POT102", "In this class, you will learn correct mixing and stirring of ingredients to create mixtures with magical effects."),
            new Course("Transfiguration", "TR442", "In this class, you will learn the art of changing the form or appearance of an object.")
        };

		for (int i = 0; i < courses.length; i++) {
			courseRepository.save(courses[i]);
		}
 
	}

}
