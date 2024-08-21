package com.taskManager.TaskManager.requests;

public class SigInRequest {
    private String userName;
    private String password;

    public SigInRequest() {
    }

    public SigInRequest(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}


