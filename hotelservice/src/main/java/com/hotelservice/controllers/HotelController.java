package com.hotelservice.controllers;


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

import com.hotelservice.entities.Hotel;
import com.hotelservice.services.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {
	
	@Autowired
	private HotelService hotelService;
	
	// create 
	@PostMapping
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
		
       return  ResponseEntity.status(HttpStatus.CREATED).body(hotelService.create(hotel));
	}
	
	 // get single
	
	@GetMapping("/{id}")
	public ResponseEntity<Hotel> getSingle( @PathVariable("id") String hotelId){
		
       return  ResponseEntity.status(HttpStatus.OK).body(hotelService.get(hotelId));
	}
	

	// get all
	@GetMapping
	public ResponseEntity<List<Hotel>> getAll(Hotel hotel){
		return ResponseEntity.ok(hotelService.getAll());
	}
}
