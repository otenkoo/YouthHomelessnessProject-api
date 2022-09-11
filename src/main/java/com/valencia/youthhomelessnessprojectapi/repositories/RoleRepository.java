package com.valencia.youthhomelessnessprojectapi.repositories;

import com.valencia.youthhomelessnessprojectapi.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>  {

}
