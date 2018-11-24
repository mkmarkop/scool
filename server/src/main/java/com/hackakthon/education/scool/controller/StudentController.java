package com.hackakthon.education.scool.controller;

import com.hackakthon.education.scool.model.entity.Student;
import com.hackakthon.education.scool.model.repository.StudentRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class StudentController {

    private StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/students")
    @CrossOrigin(origins = "http://localhost:4200")
    public Collection<Student> getStudents() {
        return studentRepository.findAll();
    }
}
