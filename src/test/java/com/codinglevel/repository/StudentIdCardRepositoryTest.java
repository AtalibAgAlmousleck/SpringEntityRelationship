package com.codinglevel.repository;

import com.codinglevel.entities.Book;
import com.codinglevel.entities.Student;
import com.codinglevel.entities.StudentIdCard;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class StudentIdCardRepositoryTest {

    private final StudentIdCardRepository studentIdCardRepository;
    private final StudentRepository studentRepository;

    @Autowired
    StudentIdCardRepositoryTest(StudentIdCardRepository studentIdCardRepository,
                                StudentRepository studentRepository) {
        this.studentIdCardRepository = studentIdCardRepository;
        this.studentRepository =studentRepository;
    }

    @Test
    void saveStudent() {

//        Student student = Student.builder()
//                .firstName("Hamdi")
//                .lastName("Anara")
//                .email("hamdi@gmail.com")
//                .age(22)
//                .build();
//
//        student.addBook(
//                new Book("Clean Code", LocalDateTime.now())
//        );
//
//        student.addBook(
//                new Book("Flutter Code", LocalDateTime.now().minusDays(4))
//        );
//
//        student.addBook(
//                new Book("Java Code", LocalDateTime.now().minusYears(1))
//        );
//
//        StudentIdCard studentIdCard = StudentIdCard.builder()
//                .cardNumber("LX202205")
//                .student(student)
//                .build();
//
//        studentIdCardRepository.save(studentIdCard);

    }

    @Test
    void selectStudentById() {
        studentIdCardRepository.findById(1L)
                .ifPresent(System.err::println);
    }
}