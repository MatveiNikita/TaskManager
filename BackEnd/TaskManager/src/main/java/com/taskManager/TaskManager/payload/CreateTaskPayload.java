package com.taskManager.TaskManager.payload;

import com.taskManager.TaskManager.model.Priority;
import com.taskManager.TaskManager.model.TaskStatus;
import com.taskManager.TaskManager.model.User;

public record CreateTaskPayload(String title, String description, TaskStatus status, Priority priority, User owner){
}
