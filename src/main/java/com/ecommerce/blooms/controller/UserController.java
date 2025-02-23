package com.ecommerce.blooms.controller;

import com.ecommerce.blooms.model.User;
import com.ecommerce.blooms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/id")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }
}
