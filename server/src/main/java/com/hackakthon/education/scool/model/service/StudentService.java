package com.hackakthon.education.scool.model.service;

import com.hackakthon.education.scool.model.entity.Student;

import java.util.List;

public interface StudentService {

    public abstract Student getStudentById(Long id);
    public abstract void saveStudent(Student student);
    public abstract void updateStudent(Student student);
    public abstract void deleteStudent(Long id);
    public abstract List<Student> getAllStudents();

}
