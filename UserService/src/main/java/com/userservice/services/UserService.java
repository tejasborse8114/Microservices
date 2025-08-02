package com.userservice.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.userservice.entites.User;


public interface UserService {
	
	User saveUser(User user);
	
   List<User> getAllUser();
   
   User getUser(String userId);
   
   // detele 
   // update
}

