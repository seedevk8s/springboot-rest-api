package com.javaguides.springbootrestapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
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

    @GetMapping("students/{id}")
    public Student studentPathVariable(@PathVariable int id) {
        return new Student(id, "hojin", "chu");
    }

    @GetMapping("students2/{id}")
    public Student studentPathVariable2(@PathVariable("id") int studentId) {
        return new Student(studentId, "les", "vig");
    }

    @GetMapping("students3/{id}/{first-name}/{last-name}")
    public Student studentPathVariable3(@PathVariable("id") int studentId,
                                        @PathVariable("first-name") String firstName,
                                        @PathVariable("last-name") String lastName) {
        return new Student(studentId, firstName, lastName);
    }

    @GetMapping("students4/{ids}/{first-name}/{last-name}")
    public Student studentPathVariable4(@PathVariable("ids") int studentId,
                                        @PathVariable("first-name") String firstName,
                                        @PathVariable("last-name") String lastName) {
        return new Student(studentId, firstName, lastName);
    }    

    @GetMapping("students/query")
    public Student studentRequestVariable(@RequestParam int id) {
        return new Student(id, "hojin", "chu");
    }

    @GetMapping("students2/query")
    public Student studentRequestVariable2(@RequestParam int id,
                                            @RequestParam String firstName,
                                            @RequestParam String lastName) {
        return new Student(id, firstName, lastName);
    }    

    @PostMapping("students/create")
    public Student createStudent(@RequestBody Student student) {
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }

    @PostMapping("students2/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent2(@RequestBody Student student) {
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }    

}
