package com.hackakthon.education.scool.model.repository;

import com.hackakthon.education.scool.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@CrossOrigin(origins = "http://localhost:4200")
public interface StudentRepository extends JpaRepository<Student, Long> {

    Student findStudentByFirstName(String firstName);

}
