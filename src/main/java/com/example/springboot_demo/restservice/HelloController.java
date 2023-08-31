package com.example.springboot_demo.restservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/userhello")
    public String userHello() {
        return "Hello!";
    }

    @GetMapping("/adminhello")
    public String adminHello() {
        return "Hello!";
    }

}
