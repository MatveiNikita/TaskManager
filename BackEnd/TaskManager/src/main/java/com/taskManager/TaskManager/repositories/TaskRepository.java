package com.taskManager.TaskManager.repositories;

import com.taskManager.TaskManager.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@EnableJpaRepositories
public interface TaskRepository extends JpaRepository<Task, Long> {
}
