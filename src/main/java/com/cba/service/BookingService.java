package com.cba.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cba.entity.Booking;
import com.cba.entity.Ride;
import com.cba.exception.ResourceAlreadyExist;
import com.cba.exception.ResourceNotFoundException;

@Repository
public interface BookingService {

	List<Ride> getBookingRide(Map<String, Object> requestMap) throws ResourceAlreadyExist,ResourceNotFoundException;

	Booking chooseRide(Map<String, Object> requestMap) throws ResourceNotFoundException;

	Booking calculateBill(Map<String, Object> requestMap) throws ResourceNotFoundException;

}
