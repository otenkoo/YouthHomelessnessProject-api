package com.valencia.youthhomelessnessprojectapi.services.Implementations;

import com.valencia.youthhomelessnessprojectapi.models.Role;
import com.valencia.youthhomelessnessprojectapi.repositories.RoleRepository;
import com.valencia.youthhomelessnessprojectapi.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

        @Autowired
        RoleRepository roleRepository;

        public List<Role> getAllRoles(){
                return roleRepository.findAll();
        }

}
