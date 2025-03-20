package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {

    @GetMapping("/admin/test")
    public String adminAccess() {
        return "Hello Admin! You have access to this API.";
    }

    @GetMapping("/user/test")
    public String userAccess() {
        return "Hello User! You have access to this API.";
    }
}