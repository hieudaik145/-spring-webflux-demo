package com.github.hieudaik145.app.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private Long studentId;
    private String firstName;
    private String lastName;
    private Integer year;

}
