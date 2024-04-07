package com.javaguides.springbootrestapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// @Controller
// @ResponseBody
@RestController
public class HelloWorldController {

    @GetMapping("/hello-world-kosta")
    public String helloWorld() {
        return "Hello World KOSTA!";
    }
}
