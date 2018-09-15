package com.example.userservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/foo")
public class TestController {

    @GetMapping
//    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String getFoo() {
        return "I'm foo, " + UUID.randomUUID().toString();
    }
}
