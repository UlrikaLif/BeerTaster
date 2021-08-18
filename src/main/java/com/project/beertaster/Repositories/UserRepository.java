package com.project.beertaster.Repositories;

import com.project.beertaster.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

     public User findByUsername(String user);
}
