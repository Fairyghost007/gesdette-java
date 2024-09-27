package org.example.data.services;

import java.util.List;

import org.example.data.core.config.service.impl.ServiceImpl;
import org.example.data.entities.User;
import org.example.data.repositories.db.UserRepositoryDbImpl;
import org.example.data.repositories.db.UserRepositoryDbImpl;

public class UserServiceImpl extends ServiceImpl<User>{
    private UserRepositoryDbImpl userRepository;

    public UserServiceImpl(UserRepositoryDbImpl userRepository) {
        this.userRepository = userRepository;
    }

    public void create(User user) {
        userRepository.insert(user);
    }

    public List<User> findAll() {
        return userRepository.selectAll();
    }

    public User search(String login) {
        return userRepository.selectByLogin(login);
    }
}