package com.hackakthon.education.scool;

import com.hackakthon.education.scool.model.entity.Student;
import com.hackakthon.education.scool.model.repository.StudentRepository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class StudentJpaTest {

        @Autowired
        private StudentRepository studentRepository;


    @Test
    public void whenFindByName_thenReturnStudent() {
        // given
        //Long expectedId = new Random().nextLong();
        Student alex = Student.builder().firstName("alex").build();

        System.err.println("alex = "+alex);

        studentRepository.save(alex);
        //entityManager.flush();

        // when


        Student found = studentRepository.findStudentByFirstName("alex");

        System.err.println("found = "+found);

        found.setFirstName("pippo");
        studentRepository.save(found);

        Student found1 = studentRepository.findStudentByFirstName("pippo");

        // then
        Assert.assertEquals(found1.getFirstName(), "pippo");
    }


}
