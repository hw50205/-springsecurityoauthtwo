package com.example.userservice.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.UUID;

@RestController
@RequestMapping("/foo")
public class TestController {

    @GetMapping
//    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String getFoo(Principal principal) {
        return "I'm " + principal.getName() + ", " + UUID.randomUUID().toString();
    }
}
