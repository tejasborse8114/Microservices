package com.hotelservice.services;

import java.util.List;

import java.util.List;

import com.hotelservice.entities.Hotel;

public interface HotelService {
	
	
	//create 
	
	Hotel create(Hotel hotel);
	
	// get all 
	
	List<Hotel> getAll();
	
	// get single hotel
	
	Hotel get(String id);
	

}
