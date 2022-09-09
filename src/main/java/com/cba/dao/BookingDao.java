package com.cba.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.cba.entity.Booking;
@Component
public class BookingDao {
	
	public static Map<Integer, Booking> bookingMap=new HashMap<>();

	

}
