package com.example.userservice.jwt;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "service-auth", fallback = AuthServiceHystrix.class)
public interface AuthServiceClient {

    @PostMapping("/oauth/token")
    JWT getToken(@RequestHeader(value = "Authorization") String authorization, @RequestParam("grant_type") String type, @RequestParam("username") String username, @RequestParam("password") String password);
}
