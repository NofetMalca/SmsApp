package com.example.springStart.BaseORM.Services;

import com.example.springStart.BaseORM.Models.User;
import com.example.springStart.BaseORM.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAll() {
        return this.userRepository.findAll();
    }

    public Optional<User> getById(String id) {
        return this.userRepository.findById(id);
    }

    public String authenticateUser(User user) {
        return this.userRepository.findByUserNameAndUserPassword(user.userName(), user.userPassword()).userId.id();
    }

}
