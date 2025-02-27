package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping
@RestController("api")
public class SaludoController {
    @GetMapping("/saludo")
    public String index() {
        return "Hello, API RESTful";
    }
}
