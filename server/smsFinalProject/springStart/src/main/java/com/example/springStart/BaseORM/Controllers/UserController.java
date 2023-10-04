package com.example.springStart.BaseORM.Controllers;

import com.example.springStart.BaseORM.Models.User;
import com.example.springStart.BaseORM.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    // Example: http://localhost:9000/users
    @CrossOrigin
    @GetMapping("")
    public List<User> getAll() {
        return this.userService.getAll();
    }

    // Example: http://localhost:9000/users/270

    @GetMapping("/{id}")
    public Optional<User> getById(@PathVariable String id) {
        return this.userService.getById(id);
    }

    //Example: http://localhost:9000/users/login/
    @CrossOrigin
    @PostMapping("/login")
    public String authenticateUser(@RequestBody User user) {
        return this.userService.authenticateUser(user);
    }


}
