package com.scylladb.scylla.controller;

import com.scylladb.scylla.model.User;
import com.scylladb.scylla.model.UserJPA;
import com.scylladb.scylla.service.UserJPAService;
import com.scylladb.scylla.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/usersjpa")
public class UserJpaController {

    @Autowired
    private UserJPAService userService;

    @GetMapping
    public List<UserJPA> getAllUsers() {
        return userService.findAll();
    }
    @GetMapping("/{id}")
    public UserJPA getUserById(@PathVariable UUID id) {
        return userService.findById(id);
    }

    @PostMapping
    public UserJPA createUser(@RequestBody UserJPA user) {
        return userService.save(user);
    }

    @PutMapping("/{id}")
    public UserJPA updateUser(@PathVariable UUID id, @RequestBody UserJPA user) {
        user.setId(id);
        return userService.save(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable UUID id) {
        userService.deleteById(id);
    }
}
