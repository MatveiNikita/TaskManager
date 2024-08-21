package com.taskManager.TaskManager.controller;

import com.taskManager.TaskManager.payload.CreateUserPayload;
import com.taskManager.TaskManager.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CreateUserController {
    private final UserService userService;

    public CreateUserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("create")
    public String returnCreateForm(){
        return "creating";
    }

        @PostMapping("/save-created")
    public String createNewUser(@ModelAttribute CreateUserPayload createUserPayload, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            return "creating";
        }
            System.out.println(createUserPayload);
            System.out.println(model);
        userService.createUser(createUserPayload);
        return "redirect: /login";
    }
}
