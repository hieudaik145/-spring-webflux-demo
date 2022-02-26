package com.github.hieudaik145.app.webclient;

import com.github.hieudaik145.app.service.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Predicate;

@Service
public class WebClientService {

    @Autowired
    private WebClient webClient;

    public void getStudent() {
        Mono<Student> studentMono = webClient.get()
                .uri("/student/{id}", 2L)
                .retrieve()
                .onStatus(Predicate.not(HttpStatus::is2xxSuccessful), clientResponse -> Mono.error(new StudentServiceException("Error while communicating to student service")))
                .bodyToMono(Student.class);

        studentMono.subscribe(System.out::println);
        System.out.println("Webclient demonstrate non-blocking value");
    }

    public void getStudentList() {
        Flux<Student> studentFlux = webClient.get()
                .uri("/student")
                .retrieve()
                .onStatus(Predicate.not(HttpStatus::is2xxSuccessful), clientResponse -> Mono.error(new StudentServiceException("Error while communicating to student service")))
                .bodyToFlux(Student.class);
        studentFlux.subscribe(System.out::println);

        System.out.println("Webclient demonstrate non-blocking value");
    }

    public void getRestStudent() {
        Flux<Student> studentFlux = webClient.get()
                .uri("/rest/students")
                .retrieve()
                .onStatus(Predicate.not(HttpStatus::is2xxSuccessful), clientResponse -> Mono.error(new StudentServiceException("Error while communicating to student service")))
                .bodyToFlux(Student.class);

        studentFlux.subscribe(System.out::println);

        System.out.println("Webclient call rest api demonstrate non-blocking value");
    }
}
