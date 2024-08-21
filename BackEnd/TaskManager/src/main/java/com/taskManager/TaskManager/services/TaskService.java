package com.taskManager.TaskManager.services;

import com.taskManager.TaskManager.model.Task;
import com.taskManager.TaskManager.payload.CreateTaskPayload;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface TaskService{
    void createTask(CreateTaskPayload taskPayload, Long idOfOwner);
    void getTaskById(Long ifOfTask);
    void updateDescriptionOfTask(Long idOfTask,String description);
    void deleteTaskById(Long idOfTask);
}
