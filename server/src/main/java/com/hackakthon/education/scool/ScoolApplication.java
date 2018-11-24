package com.hackakthon.education.scool;

import com.hackakthon.education.scool.model.entity.Student;
import com.hackakthon.education.scool.model.repository.StudentRepository;
import com.hackakthon.education.scool.model.service.StudentService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class ScoolApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScoolApplication.class, args);
	}

	@Bean
    ApplicationRunner init(StudentService repository) {
	    return args -> {
            Stream.of(

                    "Oscar",
                    "Paola",
                    "Marko"
            ).forEach(name -> {
                Student s = Student.builder().firstName(name).build();
                repository.saveStudent(s);
            });
            repository.getAllStudents().forEach(System.out::println);
        };
    }
}
