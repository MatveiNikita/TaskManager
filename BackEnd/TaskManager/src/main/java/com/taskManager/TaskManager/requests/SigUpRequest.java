package com.taskManager.TaskManager.requests;

import lombok.Data;


public class SigUpRequest {
    private String username;
    private String email;
    private String password;

    public SigUpRequest() {
    }

    public SigUpRequest(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
