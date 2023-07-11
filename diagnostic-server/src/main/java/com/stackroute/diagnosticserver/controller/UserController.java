package com.stackroute.diagnosticserver.controller;

import com.stackroute.diagnosticserver.Exception.UserNotFoundException;
import com.stackroute.diagnosticserver.config.JwtGenerator;
import com.stackroute.diagnosticserver.model.User;
import com.stackroute.diagnosticserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// Mark as Controller
// Mark the class with @RequestMapping
// Mark the class with @CrossOrigin
@RestController
@RequestMapping("api/v1/user")
@CrossOrigin("*")
public class UserController {

    // Autowire the UserService
    @Autowired
    private UserService userService;

    // Autowire the JwtGenerator
    @Autowired
    private JwtGenerator jwtGenerator;

    // Mark the method with @PostMapping to save the user
    @PostMapping("/register")
    public ResponseEntity<?> postUser(@RequestBody User user){
        try{
            userService.saveUser(user);
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }


    // Mark the method with @PostMapping to login the user
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user) {
        try {
            // Check if the userName or password is empty
            if(user.getUserName() == null || user.getPassword() == null) {
                throw new UserNotFoundException("UserName or Password is Empty");
            }
            // Call the getUserByNameAndPassword method of userService
            User userData = userService.getUserByNameAndPassword(user.getUserName(), user.getPassword());
            if(userData == null){
                throw new UserNotFoundException("UserName or Password is Invalid");
            }
            // Return the token generated by jwtGenerator
            return new ResponseEntity<>(jwtGenerator.generateToken(userData), HttpStatus.OK);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/restricted")
    public ResponseEntity<?> getRestrictedMessage() {
        return new ResponseEntity<>("This is a restricted message", HttpStatus.OK);
    }
}
