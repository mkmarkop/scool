package com.hackakthon.education.scool.controller;

import com.hackakthon.education.scool.model.entity.Student;
import com.hackakthon.education.scool.model.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

        @GetMapping("/students/{id}")
    public ResponseEntity getStudent(@PathVariable("id") Long id) {

        Student student = studentService.getStudentById(id);
        if (student == null) {
            return new ResponseEntity("No Student found for ID " + id, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(student, HttpStatus.OK);
    }

    @PostMapping(value = "/students")
    public ResponseEntity createStudent(@RequestBody Student student) {

        studentService.saveStudent(student);

        return new ResponseEntity(student, HttpStatus.OK);
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity deleteStudent(@PathVariable Long id) {
        if (null == studentService.getStudentById(id)) {
            return new ResponseEntity("No Student found for ID " + id, HttpStatus.NOT_FOUND);
        }

        studentService.deleteStudent(id);
        return new ResponseEntity(id, HttpStatus.OK);

    }

    @PutMapping("/students/{id}")
    public ResponseEntity updateStudent(@PathVariable Long id, @RequestBody Student student) {

        if (null == studentService.getStudentById(id)) {
            return new ResponseEntity("No Student found for ID " + id, HttpStatus.NOT_FOUND);
        }

        studentService.updateStudent(student);
        return new ResponseEntity(student, HttpStatus.OK);
    }
}
