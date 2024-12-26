package com.pbo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class App {

    @GetMapping()
    private Map<String, Object> home() {
        HashMap<String, Object> hmap = new HashMap();
        hmap.put("message", "Hello from Java && Spring!");
        return hmap;
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
