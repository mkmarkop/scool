package com.hackakthon.education.scool;

import com.hackakthon.education.scool.model.entity.Student;
import com.hackakthon.education.scool.model.repository.StudentRepository;
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
    ApplicationRunner init(StudentRepository repository) {
	    return args -> {
            Stream.of(
                    "Daniel",
                    "Oscar",
                    "Paola",
                    "Marko"
            ).forEach(name -> {
                Student student = new Student();
                student.setFirstName(name);
                repository.save(student);
            });
            repository.findAll().forEach(System.out::println);
        };
    }
}
