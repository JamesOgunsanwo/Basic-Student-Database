package com.example.demo.dao;

import com.example.demo.model.Student;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("fakeDao")
public class fakeDaoImplFake implements FakeStudentDao {

    private final Map<UUID, Student> database;

    public fakeDaoImplFake() {
        database = new HashMap<>();
        UUID id = UUID.randomUUID();
        database.put(id, new Student(id, "John" , "Smith" ,"CS" ,22 ));
    }

    @Override
    public int insertNewStudent(UUID studentId, Student student) {
        database.put(studentId, student);
        return 1;
    }

    @Override
    public Student selectStudentById(UUID studentId) {
        return database.get(studentId);
    }

    @Override
    public List<Student> selectAllStudents() {
        return new ArrayList<>(database.values());
    }

    @Override
    public int updateStudentById(UUID studentId, Student studentUpdate) {
        database.put(studentId, studentUpdate);
        return 1;
    }

    @Override
    public int deleteStudentById(UUID studentId) {
        database.remove(studentId);
        return 1;
    }
}
