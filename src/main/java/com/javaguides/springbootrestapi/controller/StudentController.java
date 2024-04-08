package com.javaguides.springbootrestapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaguides.springbootrestapi.bean.Student;
import java.util.*;

@RestController
public class StudentController {

    @GetMapping("student")
    public Student getStudent() {
        Student student = new Student(1, "hojin", "chu");
        return student;
    }

    @GetMapping("students")
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "hojin", "chu"));
        students.add(new Student(2, "les1", "vig1"));
        students.add(new Student(3, "les2", "vig2"));
        students.add(new Student(4, "les3", "vig3"));
        return students;
    }
}
