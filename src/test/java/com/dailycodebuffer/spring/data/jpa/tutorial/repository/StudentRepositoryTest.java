package com.dailycodebuffer.spring.data.jpa.tutorial.repository;

import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Guardian;
import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .emailId("paul@paul.com")
                .firstName("Paul")
                .lastName("Thomas")
                //.guardianName("Rory Thomas")
                //.guardianEmail("rory@rory.com")
                //.guardianMobile("07540956526")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian() {
        Guardian guardian = Guardian.builder()
                .email("test23@test.com")
                .name("Hello Paul")
                .mobile("0754322222")
                .build();

        Student student = Student.builder()
                .firstName("Caitlin")
                .emailId("test2@Test2.com")
                .lastName("Thomas")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudents() {
        List<Student> studentList = studentRepository.findAll();
        System.out.println("Student List = "+ studentList);
    }

    @Test
    public void printStudentByFirstName() {
        List<Student> students = studentRepository.findByFirstName("Caitlin");
        System.out.println("Student by Name = "+ students);
    }

    @Test
    public void printStudentByFirstNameContaining() {
        List<Student> students = studentRepository.findByFirstNameContaining("Pa");
        System.out.println("Student by Name containing = "+ students);
    }

    @Test
    public void printStudentBasedOnGuardianName() {
        List<Student> students = studentRepository.findByGuardianName("Hello Paul");
        System.out.println("Student by guardian name = "+ students);
    }

    @Test
    public void printStudentBasedOnLastNameNotNull() {
        List<Student> students = studentRepository.findByLastNameNotNull();
        System.out.println("Student by last name not null = "+ students);
    }
}
