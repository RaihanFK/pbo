package com.pbo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class App {

    @GetMapping()
    private String home() {
        return "Hello from Java && Spring!";
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
