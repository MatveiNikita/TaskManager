package com.taskManager.TaskManager.services;

import com.taskManager.TaskManager.model.Task;
import com.taskManager.TaskManager.model.User;
import com.taskManager.TaskManager.payload.CreateTaskPayload;
import com.taskManager.TaskManager.repositoties.TaskRepository;
import com.taskManager.TaskManager.repositoties.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class TaskServiceImpl implements TaskService{

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void createTask(CreateTaskPayload taskPayload, UUID idOfOwner) {
        Optional<User> owner = userRepository.findById(idOfOwner);
        Task newTask = new Task(taskPayload.title(), taskPayload.description(), taskPayload.status(), taskPayload.priority(), owner.get());
    }

    @Override
    public void getTaskById(UUID ifOfTask) {

    }

    @Override
    public void updateDescriptionOfTask(UUID idOfTask, String description) {

    }

    @Override
    public void deleteTaskById(UUID idOfTask) {

    }
}
