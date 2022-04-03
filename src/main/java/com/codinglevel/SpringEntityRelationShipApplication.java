package com.codinglevel;

import com.codinglevel.entities.*;
import com.codinglevel.repository.StudentIdCardRepository;
import com.codinglevel.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class SpringEntityRelationShipApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringEntityRelationShipApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(
            StudentRepository studentRepository,
            StudentIdCardRepository studentIdCardRepository
    ) {
        return args -> {
            Student student = new Student(
                    "Nelson",
                    "Jamal",
                    "hello@gmail.com",
                    35
            );

            student.addBook(
                   new Book(
                           "Golang Code",
                           LocalDateTime.now().minusDays(1)
                   )
            );
//            student.enrolToCourse(
//                    new Course("Computer Science", "IT")
//            );
//            student.enrolToCourse(
//                    new Course("UI Design", "IT")
//            );

            student.addEnrolment(
                    new Enrolment(
                            new EnrolmentId(2L, 3L),
                            student,
                            new Course(
                                    "Spring Data JPA",
                                    "IT"
                            ),
                            LocalDateTime.now().minusDays(2)
                    )
            );

            student.addEnrolment(
                    new Enrolment(
                            new EnrolmentId(2L, 3L),
                            student,
                            new Course(
                                    "Go",
                                    "IT"
                            ),
                            LocalDateTime.now()
                    )
            );

            StudentIdCard studentIdCard = new
                    StudentIdCard(
                            "LX202202",
                    student
            );

            student.setStudentIdCard(studentIdCard);

//            studentIdCardRepository.save(studentIdCard);
            studentRepository.save(student);

//            studentRepository.findById(1L)
//                    .ifPresent(System.err::println);
        };
    }
}
