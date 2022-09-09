package com.cba.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cba.entity.Booking;
import com.cba.entity.Ride;
import com.cba.exception.ResourceAlreadyExist;
import com.cba.exception.ResourceNotFoundException;
import com.cba.service.BookingService;

@RestController
public class BookingController {
	@Autowired
	BookingService bookingService;

	/**
	 * this API will return all available driver
	 * 
	 * @param requestMap
	 * @return
	 */
	@PostMapping(path = "/booking/ride")
	public @ResponseBody List<Ride> getBookingRide(@RequestBody Map<String, Object> requestMap)
			throws ResourceAlreadyExist,ResourceNotFoundException {

		return bookingService.getBookingRide(requestMap);

	}

	/**
	 * This APi will return Booking details and set the user and driver location
	 * that is destination location
	 * 
	 * @param requestMap
	 * @return Booking details
	 */
	@PostMapping(path = "/booking/select")
	public @ResponseBody Booking chooseRide(@RequestBody Map<String, Object> requestMap)
			throws ResourceNotFoundException {

		return bookingService.chooseRide(requestMap);

	}

	/**
	 * this API will calculate the bill of journey
	 * 
	 * @param requestMap
	 * @return return the calculated bill
	 */

	@GetMapping(path = "/booking/bill")
	public @ResponseBody Booking calculateBill(@RequestBody Map<String, Object> requestMap)
			throws ResourceNotFoundException {
		return bookingService.calculateBill(requestMap);

	}

}
