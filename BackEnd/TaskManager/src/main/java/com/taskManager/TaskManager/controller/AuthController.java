package com.taskManager.TaskManager.controller;

import com.taskManager.TaskManager.JWT.JwtAuthenticationResponse;
import com.taskManager.TaskManager.requests.SigInRequest;
import com.taskManager.TaskManager.requests.SigUpRequest;
import com.taskManager.TaskManager.services.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {
    private final AuthenticationService authenticationService;

    @Autowired
    public AuthController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @GetMapping("/sign-up")
    public String signUpForm() {
        return "signUpForm";
    }

    @PostMapping("/sign-up")
    public String signUp(@RequestBody @Valid SigUpRequest sigUpRequest){
        authenticationService.signUp(sigUpRequest);
        return "redirect: /sign-in";
    }

    @GetMapping("/sign-in")
    public String signIn(){
        return "login";
    }

    @PostMapping("/sign-in")
    public void signIn(@RequestBody @Valid SigInRequest sigInRequest){
        authenticationService.signIn(sigInRequest);
    }
}
