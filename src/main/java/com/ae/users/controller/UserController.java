package com.ae.users.controller;

import com.ae.users.entity.User;
import com.ae.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody final User user) {
       User createdUser = service.createUser(user);
       return new ResponseEntity<User>(createdUser, HttpStatus.CREATED);
    }

    @PutMapping("/user")
    public ResponseEntity<?> updateUser(@RequestBody final User user) {
        User createdUser = service.updateUser(user);
        if (createdUser == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(createdUser, HttpStatus.OK);
    }

    @GetMapping("/user")
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = service.getUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/user/id/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
        User createdUser = service.getUserById(id);
        return new ResponseEntity<User>(createdUser, HttpStatus.OK);
    }

    @GetMapping("/user/username/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable("username") String username) {
        User createdUser = service.getUserByUsername(username);
        return new ResponseEntity<User>(createdUser, HttpStatus.OK);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable("id") Long id) {
        service.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
