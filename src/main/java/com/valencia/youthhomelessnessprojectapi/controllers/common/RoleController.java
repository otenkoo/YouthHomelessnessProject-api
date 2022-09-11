package com.valencia.youthhomelessnessprojectapi.controllers.common;

import com.valencia.youthhomelessnessprojectapi.models.Role;
import com.valencia.youthhomelessnessprojectapi.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// TO DO:
// SECURITY: SECURE THIS CONTROLLER ONLY ADMINS CAN ACCESS
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    RoleService rollService;

    @GetMapping()
    public ResponseEntity<List<Role>> getAllRoles() {
        return ResponseEntity.ok(rollService.getAllRoles());
    }

}
