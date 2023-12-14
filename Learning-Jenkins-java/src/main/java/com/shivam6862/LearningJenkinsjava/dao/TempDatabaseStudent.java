package com.shivam6862.LearningJenkinsjava.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.shivam6862.LearningJenkinsjava.model.Student;

@Repository("tempDao")
public class TempDatabaseStudent implements StudentDao {
    private static List<Student> DB = new ArrayList<>();

    @Override
    public int insertNewStudent(UUID studentId, Student student) {
        DB.add(new Student(studentId, student.getName(), student.getEmail()));
        return 1;
    }

    @Override
    public List<Student> selectAllStudents() {
        return DB;
    }

    @Override
    public Optional<Student> selectStudentById(UUID studentId) {
        return DB.stream().filter(student -> student.getId().equals(studentId)).findFirst();
    }

    @Override
    public int updateStudentById(UUID studentId, Student student) {
        return selectStudentById(studentId).map(s -> {
            int indexOfStudentToUpdate = DB.indexOf(s);
            if (indexOfStudentToUpdate >= 0) {
                DB.set(indexOfStudentToUpdate, new Student(studentId, student.getName(), student.getEmail()));
                return 1;
            }
            return 0;
        }).orElse(0);
    }

    @Override
    public int deleteStudentById(UUID studentId) {
        Optional<Student> studentMaybe = selectStudentById(studentId);
        if (studentMaybe.isEmpty()) {
            return 0;
        }
        DB.remove(studentMaybe.get());
        return 1;
    }
}
