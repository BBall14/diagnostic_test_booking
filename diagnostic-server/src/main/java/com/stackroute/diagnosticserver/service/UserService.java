package com.stackroute.diagnosticserver.service;


import com.stackroute.diagnosticserver.Exception.UserNotFoundException;
import com.stackroute.diagnosticserver.model.User;
import com.stackroute.diagnosticserver.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

// annotate with Service
@Service
public class UserService {

    // Autowire the UserRepo
    @Autowired
    private UserRepo userRepo;

    // Autowire the PasswordEncoder
    @Autowired
    private PasswordEncoder passwordEncoder;

    // Method to save user details in the database
    public void saveUser(User user) {
        // Encode the password
        String password = passwordEncoder.encode(user.getPassword());
        user.setPassword(password);
        userRepo.save(user);
    }

    // Method to get user details by name and password from the database
    public User getUserByNameAndPassword(String name, String password) throws UserNotFoundException {
        // Get user details by name from the database
        User user = userRepo.findByUserName(name);
        // If the user does not exist, throw UserNotFoundException
        if(user == null){
            throw new UserNotFoundException("Invalid id");
        }
        // If the password matches, return the user
        if (passwordEncoder.matches(password, user.getPassword())) {
            return user;
        }
        // If the password does not match, throw UserNotFoundException
        else {
            throw new UserNotFoundException("Invalid password");
        }
    }
}
