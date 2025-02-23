package com.hotel.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.hotel.service.entites.Hotel;
import com.hotel.service.exception.ResourceNotFoundException;
import com.hotel.service.repositories.HotelRepository;
import com.hotel.service.services.HotelService;

public class ServiceImpl implements HotelService {

	@Autowired
	private HotelRepository hotelRepository;
	
	
	
	@Override
	public Hotel create(Hotel hotel) {
	String hotelId=UUID.randomUUID().toString();
	hotel.setId(hotelId);
	return hotelRepository.save(hotel);
	}

	@Override
	public List<Hotel> getAll() {
		
		return hotelRepository.findAll();
	}

	@Override
	public Hotel get(String id) {
		// TODO Auto-generated method stub
		return hotelRepository.findById(id).orElseThrow((() -> new ResourceNotFoundException("hotel with givcen is not found !!")));
	}

}
