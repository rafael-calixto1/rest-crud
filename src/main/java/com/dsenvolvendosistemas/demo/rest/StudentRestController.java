package com.dsenvolvendosistemas.demo.rest;


import com.dsenvolvendosistemas.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> theStudents;

    @PostConstruct
    public void localData() {
        theStudents = new ArrayList<>();

        theStudents.add(new Student("Rafael", "Calixto"));
        theStudents.add(new Student("Cristiano", "Jr"));
        theStudents.add(new Student("Lionel", "Ronaldo"));
    }

    @GetMapping("students")
    public List<Student> getStudent() {

        return theStudents;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        //exception
        if ((studentId >= theStudents.size()) || (studentId < 0)) {
            throw new StudentNotFoundException("Student not found - " + studentId);
        }
        return theStudents.get(studentId);
    }


}




