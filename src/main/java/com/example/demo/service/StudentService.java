package com.example.demo.service;

import com.example.demo.dao.FakeStudentDao;
import com.example.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service("studentService")
public class StudentService {

    private final FakeStudentDao studentDao;

    @Autowired
    public StudentService(@Qualifier("mongoDbDao") FakeStudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public int persitNewStudent(UUID studentId, Student student){
        UUID studentUUID = studentId == null ? UUID.randomUUID() : studentId;
        return studentDao.insertNewStudent(studentUUID, student);
    }

    public Student getStudentById(UUID studentId){
        return studentDao.selectStudentById(studentId);
    }

    public List<Student> getAllStudents(){
        return studentDao.selectAllStudents();
    }

    public int updateStudentById(UUID studentId, Student studentUpdate){
        return studentDao.updateStudentById(studentId, studentUpdate);
    }

    public int deleteStudentById(UUID studentId){
        Student studentById = getStudentById(studentId);
        if (studentById == null){
            throw new IllegalStateException();
        }
        return studentDao.deleteStudentById(studentId);
    }




}
