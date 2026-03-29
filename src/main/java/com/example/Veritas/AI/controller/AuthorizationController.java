package com.example.Veritas.AI.controller;

import com.example.Veritas.AI.security.JwtService;
import com.example.Veritas.AI.service.CustomService;
import com.example.Veritas.AI.user.AppUser;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AuthorizationController {
CustomService service;
AuthenticationManager authenticationManager;
JwtService jwt;
    AuthorizationController(CustomService service,AuthenticationManager authenticationManager,JwtService jwt){
    this.service=service;
    this.authenticationManager=authenticationManager;
    this.jwt=jwt;
}
    @PostMapping("/register")
    public String  register(@RequestBody AppUser user){
service.register(user);
return "register sucessfull";
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String,String>> login(@RequestBody AppUser request)
    {
        Authentication authentication= authenticationManager.authenticate
                (new UsernamePasswordAuthenticationToken(request.getUsername(),
                        request.getPassword()));
        System.out.println("Login called for: " + request.getUsername());
        return  ResponseEntity.ok(Map.of("token",jwt.generateToken(request.getUsername())));
    }
}
