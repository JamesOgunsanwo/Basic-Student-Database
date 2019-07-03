package com.example.demo.resource;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/students")
public class StudentResource {

    private final StudentService studentService;

    @Autowired
    public StudentResource(@Qualifier("studentService") StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Student> getAllStudent(){
        return studentService.getAllStudents();
    }

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE,
            path = "/id/{studentId}"
    )
    public Student getStudentById(@PathVariable("studentId") UUID studentId){
        return studentService.getStudentById(studentId);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            path = "/insert"
    )
    public void insertStudent(@RequestBody Student student){
        UUID studentId = UUID.randomUUID();
        student.setId(studentId);
        studentService.persitNewStudent(studentId,student);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE,
            path = "/delete/{studentId}"
    )
    public int deleteUserById (@PathVariable("studentId") UUID studentId){
        return studentService.deleteStudentById(studentId);
    }

    @RequestMapping(
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            path = "/update/{studentId}"
    )
    public int updateUserById (@PathVariable("studentId") UUID studentId, @RequestBody Student student){
        return studentService.updateStudentById(studentId, student);
    }

}
