package com.valencia.youthhomelessnessprojectapi.controllers.admin;

import com.valencia.youthhomelessnessprojectapi.models.User;
import com.valencia.youthhomelessnessprojectapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


// TO DO:
// SECURITY: SECURE THIS CONTROLLER ONLY ADMINS CAN ACCESS
@RestController
@RequestMapping("/admin/user")
public class AdminUserController {

    @Autowired
    UserService userService;

    @PostMapping()
    public ResponseEntity<User> newUserAnyRole(@RequestBody User newUser) {
        if (newUser == null) {
            return ResponseEntity.badRequest().build();
        }
        else if (newUser.getUsername().isEmpty() || newUser.getPassword().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        if(userService.getUserByUsername(newUser.getUsername()) != null) {
            return ResponseEntity.badRequest().build();
        }
        else {
            return ResponseEntity.ok(userService.saveUser(newUser));
        }
    }

    @PutMapping(path = "/{username}")
    public ResponseEntity<User> updateUser(@PathVariable String username,@RequestBody User user) {
        try {

            if(userService.getUserByUsername(username) == null) {
                return ResponseEntity.badRequest().build();
            }
            return ResponseEntity.ok(userService.saveUser(user));
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
