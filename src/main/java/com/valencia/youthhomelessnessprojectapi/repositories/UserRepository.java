package com.valencia.youthhomelessnessprojectapi.repositories;

import com.valencia.youthhomelessnessprojectapi.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>  {

        User findByUsername(String username);
        User getReferenceById(Long id);


}
