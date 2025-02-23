package com.userservice.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userservice.entites.User;
import com.userservice.exception.ResourceNotFoundException;
import com.userservice.repositories.UserRepository;
import com.userservice.services.UserService;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	

	@Override
	public User saveUser(User user) {
		String randomuserId=UUID.randomUUID().toString();
		user.setUserId(randomuserId);
		return userRepository.save(user);
		}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	@Override
	public User getUser(String userId) {
		return userRepository.findById(userId).orElseThrow((() -> new ResourceNotFoundException("user with givcen is not found :"+userId)));
		}


}
