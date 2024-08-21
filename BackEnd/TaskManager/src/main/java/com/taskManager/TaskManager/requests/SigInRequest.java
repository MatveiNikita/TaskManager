package com.taskManager.TaskManager.requests;

public class SigInRequest {
    private String username;
    private String password;

    public SigInRequest() {
    }

    public SigInRequest(String userName, String password) {
        this.username = userName;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}


