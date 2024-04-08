package com.javaguides.springbootrestapi.controller2;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaguides.springbootrestapi.bean.Student;
import java.util.*;

@RestController
@RequestMapping("stu")
public class StudentController2 {      
    
    @GetMapping("student5")
    public ResponseEntity<Student> getStudent4() {
        Student student = new Student(1, "hojin", "Chu");
        return ResponseEntity.ok()
                            .header("custom-header", "hojin")
                            .body(student);
    }

    @GetMapping("students4")
    public ResponseEntity<List<Student>> getStudents2() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "hojin", "chu"));
        students.add(new Student(2, "les1", "vig1"));
        students.add(new Student(3, "les2", "vig2"));
        students.add(new Student(4, "les3", "vig3"));
        return ResponseEntity.ok(students);
    }
 
    @GetMapping("students6/{ids}/{first-name}/{last-name}")
    public ResponseEntity<Student> studentPathVariable5(@PathVariable("ids") int studentId,
                                        @PathVariable("first-name") String firstName,
                                        @PathVariable("last-name") String lastName) {
        Student student = new Student(studentId, firstName, lastName);                                            
        return ResponseEntity.ok(student);
    } 

    @GetMapping("students5/query")
    public ResponseEntity<Student> studentRequestVariable3(@RequestParam int id,
                                            @RequestParam String firstName,
                                            @RequestParam String lastName) {
        Student student = new Student(id, firstName, lastName);                                                
        return ResponseEntity.ok(student);
    } 

    @PostMapping("students5/create")
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> createStudent3(@RequestBody Student student) {
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    } 

    @PutMapping("students6/{id}/update")
    public ResponseEntity<Student> updateStudent2(@RequestBody Student student, @PathVariable("id") int studentId) {
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return ResponseEntity.ok(student);
    }

    @DeleteMapping("students6/{id}/delete")
    public ResponseEntity<String> deleteStudent2(@PathVariable("id") int studentId) {
        System.out.println(studentId);
        return ResponseEntity.ok("Student 삭제 성공함!");
    }
}
