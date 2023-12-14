package com.shivam6862.LearningJenkinsjava.testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.shivam6862.LearningJenkinsjava.api.StudentController;
import com.shivam6862.LearningJenkinsjava.model.Student;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentTest {
    @Autowired
    private StudentController studentController;

    @BeforeAll
    public static void setupAll() {
        System.out.println("Should print before all tests");
    }

    @BeforeEach
    @DisplayName("Should print before each test")
    public void setup() {
        System.out.println("Instantiating Repo");
        System.out.println(studentController);
    }

    @Test
    @DisplayName("Should create student")
    public void shouldCreateStudent() {
        Student student = new Student(UUID.randomUUID(), "Shivam", "shivam6862mau@gmai.com");
        Student student2 = new Student(UUID.randomUUID(), "Shyam", "shyam@gmai.com");
        Student student3 = new Student(UUID.randomUUID(), "Pushpendra", "Pushpendra@gmai.com");
        Student student4 = new Student(UUID.randomUUID(), "Shashank", "Shashank@gmai.com");
        System.out.println(student.getName());
        System.out.println(student.getEmail());
        System.out.println(studentController);
        studentController.addNewStudent(student);
        studentController.addNewStudent(student2);
        studentController.addNewStudent(student3);
        studentController.addNewStudent(student4);
        System.out.println("Should create Student");
        assertFalse(studentController.getAllStudents().isEmpty());
        assertEquals(4, studentController.getAllStudents().size());
        assertEquals(student.getName(), studentController.getAllStudents().get(0).getName());
    }

    @Test
    @DisplayName("Should get all Student")
    public void testgetAllStudent() {
        List<Student> alldata = studentController.getAllStudents();
        System.out.println("All Student Data");
        System.out.println(alldata);
    }

    @Test
    @DisplayName("Should get Student by id")
    public void testgetStudentRepoById() {
        List<Student> alldata = studentController.getAllStudents();
        if (alldata.size() > 0) {
            System.out.println("Student Details with index 0");
            System.out.println(alldata.get(0));
            Student StudentDetails = studentController.getStudentById(alldata.get(0).getId());
            System.out.println("Student Details with index 0");
            System.out.println(StudentDetails);
        } else {
            System.out.println("No Student Data");
        }
    }

    @Test
    @DisplayName("Should delete Student")
    public void testdeleteStudentRepo() {
        List<Student> alldata = studentController.getAllStudents();
        if (alldata.size() > 0) {
            studentController.deleteStudentById(alldata.get(0).getId());
        } else {
            System.out.println("No Student Data");
        }
    }

    @Test
    @DisplayName("Should update Student")
    public void testupdateStudentRepo() {
        List<Student> alldata = studentController.getAllStudents();
        if (alldata.size() > 0) {
            Student StudentToUpdate = new Student(
                    alldata.get(0).getId(),
                    "Shrey Mapwal",
                    "Shrey_mapwal@gmail.com");
            studentController.updateStudentById(alldata.get(0).getId(), StudentToUpdate);
        } else {
            System.out.println("No Student Data");
        }
    }

    @AfterEach
    public void tearDown() {
        System.out.println("Should Execute After Each Test");
    }

    @AfterAll
    public static void tearDownAll() {
        System.out.println("Should be executed at the end of the Test");
    }
}
