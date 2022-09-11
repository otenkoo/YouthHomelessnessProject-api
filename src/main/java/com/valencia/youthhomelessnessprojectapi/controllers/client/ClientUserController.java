package com.valencia.youthhomelessnessprojectapi.controllers.client;

import com.valencia.youthhomelessnessprojectapi.models.User;
import com.valencia.youthhomelessnessprojectapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client/user")
public class ClientUserController {

    @Autowired
    UserService userService;


    @PutMapping()
    public ResponseEntity<User> updateUser(@RequestBody User client) {
        if(userService.getUserById(client.getId()) == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(userService.saveUser(client));
    }

}
