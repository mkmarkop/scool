package com.hackakthon.education.scool.model.service;

import com.hackakthon.education.scool.model.entity.Student;
import com.hackakthon.education.scool.model.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl {

    @Autowired
    StudentRepository studentRepository;

    @Transactional
    public Student getStudentById(Long id) {
        System.err.println("LOOK FOR ID "+id);
        return studentRepository.getOne(id);
    }


    @Transactional
    public List<Student> getAllStudents() {
        System.err.println("GIVE ME ALL STUDENTS");
        return studentRepository.findAll();
    }

    @Transactional
    public void saveStudent(Student student) {

        System.err.println("save");
        Student s = studentRepository.save(student);
        System.err.println(s);


    }
    @Transactional
    public void updateStudent(Student student) {
        studentRepository.save(student);

    }
    @Transactional
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);

    }
}



