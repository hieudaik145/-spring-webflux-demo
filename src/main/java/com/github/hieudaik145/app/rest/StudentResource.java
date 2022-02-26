package com.github.hieudaik145.app.rest;

import com.github.hieudaik145.app.service.Student;
import com.github.hieudaik145.app.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

@RestController
public class StudentResource {

    @Autowired
    private StudentService studentService;

    @GetMapping("/student/{id}")
    public Mono<Student> getStudent(@PathVariable Long id) throws InterruptedException {
//        Thread.sleep(2000);

        return studentService.getStudent(id);
    }

    @GetMapping("/student")
    public Flux<Student> getStudentFlux() throws InterruptedException {
        Thread.sleep(2000);
        return studentService.getStudentList();
    }

    @GetMapping("/rest/students")
    public ResponseEntity<List<Student>> getStudentList() throws InterruptedException {
        Thread.sleep(2000);
        List<Student> target = Arrays.asList(
                new Student(1L, "VO", "HIEU", 1997),
                new Student(2L, "NGUYEN", "A", 1997),
                new Student(3L, "NGUYEN", "C", 1997),
                new Student(4L, "NGUYEN", "C", 1997));

        return ResponseEntity.ok().body(target);
    }
}
