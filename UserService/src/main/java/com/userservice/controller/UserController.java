package com.userservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userservice.entites.User;
import com.userservice.services.UserService;


@RestController
@RequestMapping("/users")
public class UserController {
	
	
	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user){
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(user));
	}

	@GetMapping("/{Id}")
	public ResponseEntity<User> createUser(@PathVariable("Id") String userId){
		return ResponseEntity.status(HttpStatus.OK).body(userService.getUser(userId));
	}

	@GetMapping
	public ResponseEntity<List<User>> getAllUser(){
		return ResponseEntity.ok(userService.getAllUser());
	}
}
