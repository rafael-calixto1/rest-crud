package com.dsenvolvendosistemas.demo.rest;

import com.dsenvolvendosistemas.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DemoRestController {
    private List<Student> theStudents;
    @PostConstruct
    public void localData(){
        theStudents = new ArrayList<>();

        theStudents.add(new Student("Rafael", "Calixto"));
        theStudents.add(new Student("Cristiano", "Jr"));
        theStudents.add(new Student("Lionel", "Ronaldo"));
    }
    @GetMapping("students")
    public List<Student> getStudent(){

        return theStudents;
    }
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        return theStudents.get(studentId);
    }
}
