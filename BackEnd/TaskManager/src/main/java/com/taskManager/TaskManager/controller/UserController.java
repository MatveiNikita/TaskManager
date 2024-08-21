package com.taskManager.TaskManager.controller;

import com.taskManager.TaskManager.model.User;
import com.taskManager.TaskManager.payload.CreateUserPayload;
import com.taskManager.TaskManager.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.UUID;

@Controller("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping()
    public String welcomePage(HttpServletRequest httpServletRequest, Model model){
        UserDetails userDetails = (UserDetails) ((Authentication)httpServletRequest.getUserPrincipal())
                .getPrincipal();
        model.addAttribute("name", userDetails.getUsername());
        return "user";
    }
}
