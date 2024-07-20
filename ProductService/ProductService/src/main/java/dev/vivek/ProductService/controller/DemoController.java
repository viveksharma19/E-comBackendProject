package dev.vivek.ProductService.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/hello")
    public ResponseEntity hello() {
        return ResponseEntity.ok("Hello");
    }

    @DeleteMapping("/hi")
    public ResponseEntity hi() {
        return ResponseEntity.ok("Hi");
    }
}
