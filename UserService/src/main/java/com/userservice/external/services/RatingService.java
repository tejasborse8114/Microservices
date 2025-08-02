package com.userservice.external.services;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.userservice.entites.Hotel;
import com.userservice.entites.Rating;

@FeignClient(name = "RATING-SERVICE")
public interface RatingService {

	// get
	@GetMapping("/ratings/{ratingId}")
	Hotel getRating(@PathVariable("ratingId") String ratingId);
	
	// post
	@PostMapping("/ratings")
	public Rating crateRating(Rating values);
	
	//put
	@PutMapping("/ratings/{ratingId}")
	public Rating UpdateRating(@PathVariable("ratignId") String ratingId,Rating rating);
	
	@DeleteMapping("/ratings/{ratingId")
	public void deleteRating(@PathVariable("ratignId") String ratingId);
}
