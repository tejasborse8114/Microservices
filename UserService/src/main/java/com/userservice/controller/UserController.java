package com.userservice.controller;

import java.util.List;

import org.slf4j.Logger;
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

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	Logger logger;

	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user) {
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(user));
	}

	@GetMapping("/{Id}")
	@CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "ratingHotelFallback")
	public ResponseEntity<User> createUser(@PathVariable("Id") String userId) {
		logger.info("Get Single User Handler:UserController");
		return ResponseEntity.status(HttpStatus.OK).body(userService.getUser(userId));
	}

	// creating fall back method for circuit breaker

	public ResponseEntity<User> ratingHotelFallback(String userId, Exception ex) {
		logger.info("Fallback is executed because service is down :", ex.getMessage());
		User user = User.builder().email("dummy@gmail.com").name("Dummy")
				.about("This user is created beacuase some services are down").userId("1234").build();
		return new ResponseEntity<>(user, HttpStatus.OK);

	}

	@GetMapping
	public ResponseEntity<List<User>> getAllUser() {
		return ResponseEntity.ok(userService.getAllUser());
	}
}
