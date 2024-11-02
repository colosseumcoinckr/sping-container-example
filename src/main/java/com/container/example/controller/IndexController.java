package com.container.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    private final ApplicationContext application;
    private final String text;

    public IndexController(ApplicationContext application, @Value("${text}") String text) {
        this.application = application;
        this.text = text;
    }

    @GetMapping("/")
    public String index() {
        return "It works! (" + text + ")";
    }

    @GetMapping("/shutdown")
    public void shutdown() {
        int exitCode = SpringApplication.exit(application, () -> 0);
        System.exit(exitCode);
    }
}
