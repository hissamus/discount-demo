package com.hissamus.store.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hissamus.store.demo.model.User;
import com.hissamus.store.demo.service.UserService;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api")
public class UserController {

	public static final Logger logger = LoggerFactory.getLogger(UserController.class);
	 
    @Autowired
    private UserService userService; 
    
    @GetMapping(value = "/user/")
    public ResponseEntity<List<User>> listAllUsers() {
        List<User> users = userService.getAllUsers();
        if (users.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }
    
    @GetMapping(value = "/user/{name}")
    public ResponseEntity<User> findByUsername(@PathVariable("name") String name) {
        Optional<User> userOptional= Optional.ofNullable(userService.findByUsername(name));
        if (!userOptional.isPresent()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<User>(userOptional.get(), HttpStatus.OK);
    }
	
}
