package com.example.demo.dao;

import com.example.demo.model.Student;

import java.util.List;
import java.util.UUID;

public interface FakeStudentDao {

    int insertNewStudent(UUID studentId, Student student);

    Student selectStudentById(UUID studentId);

    List<Student> selectAllStudents();

    int updateStudentById(UUID student, Student studentUpdate);

    int  deleteStudentById(UUID StudentId);
}
