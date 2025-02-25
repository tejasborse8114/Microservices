package com.userservice.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.userservice.entites.Hotel;
import com.userservice.entites.Rating;
import com.userservice.entites.User;
import com.userservice.exception.ResourceNotFoundException;
import com.userservice.repositories.UserRepository;
import com.userservice.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RestTemplate restTemplate;

	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	// create user
	@Override
	public User saveUser(User user) {
		String randomuserId = UUID.randomUUID().toString();
		user.setUserId(randomuserId);
		return userRepository.save(user);
	}

	// get all users
	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	// get single user
	@Override
	public User getUser(String userId) {
		// get user from database with the help of user repository

		User user = userRepository.findById(userId)
				.orElseThrow((() -> new ResourceNotFoundException("user with givcen is not found :" + userId)));

		// fetch rating of the above user from the rating service with this url
		// http://localhost:8083/ratings/users/

		Rating[] ratingsOfUser = restTemplate
				.getForObject("http://RATING-SERVICE/ratings/users/"+user.getUserId(), Rating[].class);
		logger.info("{}", ratingsOfUser);
		
		List<Rating> ratings=Arrays.stream(ratingsOfUser).toList();

		List<Rating> ratingList = ratings.stream().map(rating -> {

			// api call to hotel service to get the hotel

			ResponseEntity<Hotel> forEntity = restTemplate
					.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);
			Hotel hotel = forEntity.getBody();
			logger.info("response status code : {} ", forEntity.getStatusCode());

			// set the hotel to rating
			rating.setHotel(hotel);

			// return rating
			return rating;
		}).collect(Collectors.toList());

		user.setRatings(ratingList);

		return user;
	}

}
