package ratingservice.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ratingservice.entities.Rating;
import ratingservice.repositories.RatingRepository;
import ratingservice.services.RatingService;

@Service
public class RatingImpl implements RatingService {

	@Autowired
	private RatingRepository ratingRepository;
	
	@Override
	public Rating create(Rating rating) {
		String randomuserId=UUID.randomUUID().toString();
		rating.setRatingId(randomuserId);
		return ratingRepository.save(rating);
	}

	@Override
	public List<Rating> getRating() {
		return ratingRepository.findAll();
	}

	@Override
	public List<Rating> getByUserId(String userId) {
		
		return ratingRepository.findByUserId(userId);
	}

	@Override
	public List<Rating> getByHotelId(String hotelId) {
		
		return ratingRepository.findByHotelId(hotelId);
	}

}
