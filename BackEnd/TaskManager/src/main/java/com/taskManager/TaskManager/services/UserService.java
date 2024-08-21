package com.taskManager.TaskManager.services;

import com.taskManager.TaskManager.model.User;
import com.taskManager.TaskManager.payload.CreateUserPayload;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
@Service
public interface UserService {
    User createUser(CreateUserPayload createUserPayload);
    Optional<User> getUserById(Long idOfUser);
    void deleteUserById(Long idOfDeletedUser);

    User getByUserName(String userName);
    UserDetailsService userDetailsService();
}
