package com.hotel.service.services;

import java.util.List;

import com.hotel.service.entites.Hotel;

public interface HotelService {
	
	Hotel create(Hotel hotel);
	
   List<Hotel> getAll();
   
   Hotel get(String id);
}

