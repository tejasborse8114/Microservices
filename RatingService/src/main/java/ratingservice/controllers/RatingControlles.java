package ratingservice.controllers;

import java.util.List;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import ratingservice.entities.Rating;
import ratingservice.services.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingControlles {
    
	@Autowired
	private RatingService ratingService;

	// create rating
	@PostMapping
	public ResponseEntity<Rating> createRating(@RequestBody Rating rating) {
		return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.create(rating));
	}

	// get all
	@GetMapping
	public ResponseEntity<List<Rating>> getRating() {

		return ResponseEntity.ok(ratingService.getRating());
	}

	// get all rating by userid
	@GetMapping("/users/{id}")
	public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable("id") String userId) {

		return ResponseEntity.ok(ratingService.getByUserId(userId));
	}

	// get rating by hotel id
	@GetMapping("/hotels/{id}")
	public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable("id") String hotelId) {

		return ResponseEntity.ok(ratingService.getByHotelId(hotelId));
	}
}
