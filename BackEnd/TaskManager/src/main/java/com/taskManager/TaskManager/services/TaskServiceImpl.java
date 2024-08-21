package com.taskManager.TaskManager.services;

import com.taskManager.TaskManager.model.Task;
import com.taskManager.TaskManager.model.User;
import com.taskManager.TaskManager.payload.CreateTaskPayload;
import com.taskManager.TaskManager.repositories.TaskRepository;
import com.taskManager.TaskManager.repositories.UserRepository;
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
    public void createTask(CreateTaskPayload taskPayload, Long idOfOwner) {
        Optional<User> owner = userRepository.findById(idOfOwner);
        Task newTask = new Task(taskPayload.title(), taskPayload.description(), taskPayload.status(), taskPayload.priority(), owner.get());
    }

    @Override
    public void getTaskById(Long ifOfTask) {

    }

    @Override
    public void updateDescriptionOfTask(Long idOfTask, String description) {

    }

    @Override
    public void deleteTaskById(Long idOfTask) {

    }
}
