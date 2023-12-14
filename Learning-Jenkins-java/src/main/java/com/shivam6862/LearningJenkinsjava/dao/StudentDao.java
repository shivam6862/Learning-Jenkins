package com.shivam6862.LearningJenkinsjava.dao;

import java.util.UUID;

import com.shivam6862.LearningJenkinsjava.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentDao {

    int insertNewStudent(UUID studentId, Student student);

    default int insertNewStudent(Student student) {
        UUID studentId = UUID.randomUUID();
        return insertNewStudent(studentId, student);
    }

    List<Student> selectAllStudents();

    Optional<Student> selectStudentById(UUID studentId);

    int updateStudentById(UUID studentId, Student student);

    int deleteStudentById(UUID studentId);
}