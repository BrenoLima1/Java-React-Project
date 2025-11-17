package br.com.brenolima1.carros.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/hello")
public class HelloController {
    @GetMapping("/{path}")
    public String sayHello(@PathVariable(value = "path") String param) {
        return "Hello " + param;
    }
    
}
