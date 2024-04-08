package com.javaguides.springbootrestapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @PutMapping("students/{id}/update")
    public Student updateStudent(@RequestBody Student student, @PathVariable("id") int studentId) {
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }

    @DeleteMapping("students/{id}/delete")
    public String deleteStudent(@PathVariable("id") int studentId) {
        System.out.println(studentId);
        return "Student 삭제 성공함!";
    }

    @GetMapping("student2")
    public ResponseEntity<Student> getStudent2() {
        Student student = new Student(1, "hojin", "Chu");
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @GetMapping("student3")
    public ResponseEntity<Student> getStudent3() {
        Student student = new Student(1, "hojin", "Chu");
        return ResponseEntity.ok(student);
    }
    
    @GetMapping("student4")
    public ResponseEntity<Student> getStudent4() {
        Student student = new Student(1, "hojin", "Chu");
        return ResponseEntity.ok()
                            .header("custom-header", "hojin")
                            .body(student);
    }






    @GetMapping("students2")
    public ResponseEntity<List<Student>> getStudents2() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "hojin", "chu"));
        students.add(new Student(2, "les1", "vig1"));
        students.add(new Student(3, "les2", "vig2"));
        students.add(new Student(4, "les3", "vig3"));
        return ResponseEntity.ok(students);
    }
 
    @GetMapping("students5/{ids}/{first-name}/{last-name}")
    public ResponseEntity<Student> studentPathVariable5(@PathVariable("ids") int studentId,
                                        @PathVariable("first-name") String firstName,
                                        @PathVariable("last-name") String lastName) {
        Student student = new Student(studentId, firstName, lastName);                                            
        return ResponseEntity.ok(student);
    } 

    @GetMapping("students3/query")
    public ResponseEntity<Student> studentRequestVariable3(@RequestParam int id,
                                            @RequestParam String firstName,
                                            @RequestParam String lastName) {
        Student student = new Student(id, firstName, lastName);                                                
        return ResponseEntity.ok(student);
    } 

    @PostMapping("students3/create")
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> createStudent3(@RequestBody Student student) {
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    } 

    @PutMapping("students2/{id}/update")
    public ResponseEntity<Student> updateStudent2(@RequestBody Student student, @PathVariable("id") int studentId) {
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return ResponseEntity.ok(student);
    }

    @DeleteMapping("students2/{id}/delete")
    public ResponseEntity<String> deleteStudent2(@PathVariable("id") int studentId) {
        System.out.println(studentId);
        return ResponseEntity.ok("Student 삭제 성공함!");
    }
}
