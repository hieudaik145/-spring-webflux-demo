package com.github.hieudaik145.app.webclient;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebClientResource {

    @Autowired
    private WebClientService webClientService;

    @GetMapping("/webclient/student")
    public ResponseEntity<Void> testStudent() {

        webClientService.getStudent();

        return ResponseEntity.ok().build();
    }

    @GetMapping("/webclient/student-list")
    public ResponseEntity<Void> testStudentList() {
        webClientService.getStudentList();

        return ResponseEntity.ok().build();
    }
}
