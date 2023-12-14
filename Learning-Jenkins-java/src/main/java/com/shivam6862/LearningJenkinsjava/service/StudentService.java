package com.shivam6862.LearningJenkinsjava.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shivam6862.LearningJenkinsjava.dao.StudentDao;
import com.shivam6862.LearningJenkinsjava.model.Student;

@Service
public class StudentService {

    private final StudentDao studentDao;

    @Autowired
    public StudentService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public int addNewStudent(Student student) {
        return studentDao.insertNewStudent(student);
    }

    public List<Student> getAllStudents() {
        return studentDao.selectAllStudents();
    }

    public Optional<Student> getStudentById(UUID studentId) {
        return studentDao.selectStudentById(studentId);
    }

    public int updateStudentById(UUID studentId, Student student) {
        return studentDao.updateStudentById(studentId, student);
    }

    public int deleteStudentById(UUID studentId) {
        return studentDao.deleteStudentById(studentId);
    }
}
