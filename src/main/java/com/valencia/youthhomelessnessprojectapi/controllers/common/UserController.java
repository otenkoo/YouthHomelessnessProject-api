package com.valencia.youthhomelessnessprojectapi.controllers.common;

import com.valencia.youthhomelessnessprojectapi.models.User;
import com.valencia.youthhomelessnessprojectapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


// TO DO:
// SECURITY: SECURE THIS CONTROLLER ONLY ADMINS CAN ACCESS
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping()
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {

        if(username.isEmpty()){
            return ResponseEntity.badRequest().build();
        }

        var user = userService.getUserByUsername(username);

        if(user == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(user);
    }


    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }


    @PostMapping()
    public ResponseEntity<User> registerClient(@RequestBody User newClient) {
        if (newClient == null) {
            return ResponseEntity.badRequest().build();
        }
        else if (newClient.getUsername().isEmpty() || newClient.getPassword().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        if(userService.getUserByUsername(newClient.getUsername()) != null) {
            return ResponseEntity.badRequest().build();
        }

        //Sets role to client
        newClient.getRole().setId(3);

        return ResponseEntity.ok(userService.saveUser(newClient));
    }

}
