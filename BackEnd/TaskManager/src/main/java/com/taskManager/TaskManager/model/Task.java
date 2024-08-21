package com.taskManager.TaskManager.model;

import jakarta.persistence.*;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    private String title;
    private String description;
    @Enumerated(EnumType.STRING)
    TaskStatus status;
    @Column(name = "due_date")
    private LocalDateTime dueDate;
    @Enumerated(EnumType.STRING)
    private Priority priority;
    @ManyToOne
    private User owner;
    public Task() {
    }

    public Task(String title, String description, TaskStatus status, Priority priority, User owner) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.description = description;
        this.status = status;
        this.dueDate = LocalDateTime.now();
        this.priority = priority;
        this.owner = owner;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
