package com.dates.core_api.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class HomeController {
    @GetMapping("/")
    public String helloWorld() {
        return "Hello world!";
    }
}