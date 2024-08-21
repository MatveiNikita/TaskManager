package com.taskManager.TaskManager.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
public class WelcomeController {
    @RequestMapping("/welcome")
    public String welcomePage(HttpServletRequest request, Model model){
        UserDetails userDetails = (UserDetails) (((Authentication)request.getUserPrincipal()))
                .getPrincipal();
        String name = userDetails.getUsername();
        model.addAttribute("name", name);
        return "welcome";
    }
}
