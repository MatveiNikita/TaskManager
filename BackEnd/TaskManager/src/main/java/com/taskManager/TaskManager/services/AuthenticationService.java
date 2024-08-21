package com.taskManager.TaskManager.services;

import com.taskManager.TaskManager.model.User;
import com.taskManager.TaskManager.JWT.JwtAuthenticationResponse;
import com.taskManager.TaskManager.model.Role;
import com.taskManager.TaskManager.requests.SigInRequest;
import com.taskManager.TaskManager.requests.SigUpRequest;
import lombok.RequiredArgsConstructor;
import lombok.experimental.var;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserService userService;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(UserService userService, JwtService jwtService, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    public JwtAuthenticationResponse signUp(SigUpRequest request) {
        String encodePassword = passwordEncoder.encode(request.getPassword());
        User user = new User(request.getUsername(), encodePassword,request.getEmail());
        var jwt = jwtService.generatedToken(user);
        return new JwtAuthenticationResponse(jwt);
    }

//    public JwtAuthenticationResponse signIn(SigInRequest request){
//        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
//                request.getUserName(),
//                request.getPassword()
//        ));
//
//        var user = userService
//    }
}

