package com.userservice.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.userservice.entites.User;

public interface UserRepository extends JpaRepository<User, String>{

}
