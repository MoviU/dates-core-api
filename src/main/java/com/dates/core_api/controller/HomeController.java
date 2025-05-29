package com.dates.core_api.controller;

import org.springframework.context.annotation.Fallback;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class HomeController {
    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello world!";
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }
}