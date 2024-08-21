package com.taskManager.TaskManager.services;

import com.taskManager.TaskManager.payload.CreateTaskPayload;

import java.util.UUID;


public interface TaskService {
    void createTask(CreateTaskPayload taskPayload, UUID idOfOwner);
    void getTaskById(UUID ifOfTask);
    void updateDescriptionOfTask(UUID idOfTask,String description);
    void deleteTaskById(UUID idOfTask);
}
