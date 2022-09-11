package com.valencia.youthhomelessnessprojectapi.controllers.employee;

import com.valencia.youthhomelessnessprojectapi.models.User;
import com.valencia.youthhomelessnessprojectapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


// TO DO:
// SECURITY: SECURE THIS CONTROLLER ONLY EMPLOYEES OR ADMINS CAN ACCESS
@RestController
@RequestMapping("/employee/user")
public class EmployeeUserController {

    @Autowired
    UserService userService;

    @PostMapping()
    public ResponseEntity<User> newEmployee(@RequestBody User newEmployee) {
        if (newEmployee == null) {
            return ResponseEntity.badRequest().build();
        }
        else if (newEmployee.getUsername().isEmpty() || newEmployee.getPassword().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        if(userService.getUserByUsername(newEmployee.getUsername()) != null) {
            return ResponseEntity.badRequest().build();
        }

        //Sets the role to employee
        newEmployee.getRole().setId(2);

        return ResponseEntity.ok(userService.saveUser(newEmployee));

    }

    @PutMapping()
    public ResponseEntity<User> updateEmployee(@RequestBody User employee) {
        if(userService.getUserById(employee.getId()) == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(userService.saveUser(employee));
    }

}
