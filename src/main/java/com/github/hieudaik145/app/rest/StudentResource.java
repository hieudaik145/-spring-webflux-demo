package com.github.hieudaik145.app.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class StudentResource {

    @Autowired
    private StudentService studentService;

    @GetMapping("/student/{id}")
    public Mono<Student> getStudent(@PathVariable Long id) throws InterruptedException {
        Thread.sleep(2000);

        throw new InterruptedException();
//        return studentService.getStudent(id);
    }

    @GetMapping("/student")
    public Flux<Student> getStudentList() throws InterruptedException {
        Thread.sleep(2000);
        return studentService.getStudentList();
    }
}
