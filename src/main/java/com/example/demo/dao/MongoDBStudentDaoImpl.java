package com.example.demo.dao;

import com.example.demo.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("mongoDbDao")
public class MongoDBStudentDaoImpl implements FakeStudentDao {

    //not used
    //private final MongoDbTemplate mongoTemplate

    @Override
    public int insertNewStudent(UUID studentId, Student student) {
        return 0;
    }

    @Override
    public Student selectStudentById(UUID studentId) {
        return null;
    }

    @Override
    public List<Student> selectAllStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(UUID.randomUUID(),"Bob", "Greve", "PE", 12));
        return students;
    }

    @Override
    public int updateStudentById(UUID student, Student studentUpdate) {
        return 0;
    }

    @Override
    public int deleteStudentById(UUID StudentId) {
        return 0;
    }
}
