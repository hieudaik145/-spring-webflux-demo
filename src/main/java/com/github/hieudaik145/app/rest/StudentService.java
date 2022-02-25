package com.github.hieudaik145.app.rest;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class StudentService {

    public Mono<Student> getStudent(Long studentId) {

        return Mono.just(new Student(studentId, "VO", "HIEU", 1997));
    }

    public Flux<Student> getStudentList() {
        return Flux.just(
                new Student(1L, "VO", "HIEU", 1997),
                new Student(2L, "NGUYEN", "A", 1997),
                new Student(3L, "NGUYEN", "C", 1997),
                new Student(4L, "NGUYEN", "C", 1997)
        );
    }
}
