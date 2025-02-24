package ratingservice.services;

import java.util.List;

import ratingservice.entities.Rating;

public interface RatingService {
	
	// create
	public Rating create(Rating rating);
	
	//get all rating
	List<Rating> getRating();
	
	
	// get all by userid
	List<Rating> getByUserId(String userId);
	
	// get all by hotel
	List<Rating> getByHotelId(String hotelId);
}
