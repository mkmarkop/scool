package com.hackakthon.education.scool.controller;

import com.hackakthon.education.scool.model.entity.Student;
import com.hackakthon.education.scool.model.repository.StudentRepository;
import com.hackakthon.education.scool.model.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class StudentController {

    @Autowired
    private StudentServiceImpl studentService;


    @GetMapping("/students")
    @CrossOrigin(origins = "http://localhost:4200")
    public Collection<Student> getStudents() {
        return studentService.getAllStudents();
    }
}
