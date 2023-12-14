package com.shivam6862.LearningJenkinsjava.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentControllerhtmls {
    @GetMapping("/")
    public String index() {
        System.out.println("home Page");
        return "index";
    }

    @PostMapping("/student")
    public String student() {
        System.out.println("student Page");
        return "student";
    }
}
