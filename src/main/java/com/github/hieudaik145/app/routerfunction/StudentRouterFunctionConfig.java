package com.github.hieudaik145.app.routerfunction;

import com.github.hieudaik145.app.service.Student;
import com.github.hieudaik145.app.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.reactive.function.BodyExtractors;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;
import reactor.core.publisher.Mono;

import static java.lang.Long.parseLong;
import static org.springframework.web.servlet.function.RequestPredicates.GET;
import static org.springframework.web.servlet.function.RequestPredicates.POST;
import static org.springframework.web.servlet.function.RouterFunctions.route;
import static org.springframework.web.servlet.function.ServerResponse.ok;

@Configuration
public class StudentRouterFunctionConfig {

    @Autowired
    private StudentService studentService;

    @Bean
    public RouterFunction<ServerResponse> getStudentRoute() {
        return route(GET("/router-function/student/{id}"),
                request -> {
                    Long id = parseLong(request.pathVariable("id"));
                    return ok().body(studentService.getStudent(id));
                }
        )
                .and(route(GET("/router-function/student"),
                        request -> {
                            return ok().body(studentService.getStudentList());
                        }
                ))
                .and(route(POST("/router-function/student"),
                        request -> {
                           Student student = request.body(Student.class);
                           Mono<Student> studentMono = Mono.just(student);
                           return ok().body(studentService.addStudent(studentMono));
                        }
                        ));
    }

}
