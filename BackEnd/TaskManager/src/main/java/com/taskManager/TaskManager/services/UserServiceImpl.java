package com.taskManager.TaskManager.services;

import com.taskManager.TaskManager.model.User;
import com.taskManager.TaskManager.payload.CreateUserPayload;
import com.taskManager.TaskManager.repositoties.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(CreateUserPayload createUserPayload) {
        if (userRepository.existsByUsername(createUserPayload.name())){
            throw new RuntimeException(String.format("User with this name: /s is created", createUserPayload.name()));
        }
        if (userRepository.existsByEmail(createUserPayload.email())){
            throw new RuntimeException(String.format("User with this email: /s is created", createUserPayload.email()));
        }

        return userRepository.save(new User(createUserPayload.name(), createUserPayload.password(), createUserPayload.email()));
    }

    @Override
    public Optional<User> getUserById(UUID idOfUser) {
        return userRepository.findById(idOfUser);
    }

    @Override
    public void deleteUserById(UUID idOfDeletedUser) {
        Optional<User> deletedUser = userRepository.findById(idOfDeletedUser);
        userRepository.delete(deletedUser.get());
    }

    @Override
    public User getByUserName(String userName) {
        return userRepository.findByUsername(userName)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User with this name: /s wasn't founded", userName)));
    }

    public User getCurrentUser(){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return getByUserName(username);
    }
}
