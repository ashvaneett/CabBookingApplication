package com.cba.serviceImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.cba.dao.BookingDao;
import com.cba.dao.DriverDao;
import com.cba.dao.UserDao;
import com.cba.entity.Booking;
import com.cba.entity.Driver;
import com.cba.entity.Location;
import com.cba.entity.Ride;
import com.cba.entity.User;
import com.cba.exception.ResourceAlreadyExist;
import com.cba.exception.ResourceNotFoundException;
import com.cba.helper.Helper;
import com.cba.helper.compare;
import com.cba.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService {

	@Override
	public List<Ride> getBookingRide(Map<String, Object> requestMap)
			throws ResourceAlreadyExist, ResourceNotFoundException {
		// TODO Auto-generated method stub

		Map<Integer, Driver> driverMap = DriverDao.driversMap;
		Map<Integer, Booking> bookingMap = BookingDao.bookingMap;
		Map<Integer, User> userMap = UserDao.usersMap;
		int bookingId = Integer.parseInt(requestMap.get("bookingId").toString());
		int userId = Integer.parseInt(requestMap.get("userId").toString());
		// checking id Booking Already Exists
		if (!bookingMap.containsKey(bookingId)) {
			List<Ride> availableDriversList = new ArrayList<>();
			if (requestMap.containsKey("sourceLocation") && requestMap.containsKey("destinationLocation")) {
				Map<String, Object> sourceMap = (Map<String, Object>) requestMap.get("sourceLocation");
				Map<String, Object> destinationMap = (Map<String, Object>) requestMap.get("destinationLocation");
				// fetching locations from request
				Location sourceLocation = new Location(Integer.parseInt(sourceMap.get("x").toString()),
						Integer.parseInt(sourceMap.get("y").toString()));
				Location destinationLocation = new Location(Integer.parseInt(destinationMap.get("x").toString()),
						Integer.parseInt(destinationMap.get("y").toString()));
				Helper helper = new Helper();
				double journeyDistance = helper.getDistance(sourceLocation, destinationLocation);
				if (journeyDistance <= 0) {
					throw new ResourceNotFoundException(
							"NOT A Valid Journey Select Valid Destinatin of Journey :: Distance :: " + journeyDistance);
				}
				// init new booking object to store data
				if(userMap.containsKey(userId)) {
				userMap.get(userId).setLocation(sourceLocation);
				}
				else {
					throw new ResourceNotFoundException("User Not Found For Id You Provided :: " + userId);
				}
				Booking booking = new Booking();
				booking.setBookingId(bookingId);
				booking.setDestination(destinationLocation);
				booking.setSource(sourceLocation);
				booking.setUserId(userId);
				// putting booking to the booking map
				bookingMap.put(bookingId, booking);
				// Logic for selecting available driver according to business logic
				for (int driverId : driverMap.keySet()) {
					Driver currDriver = driverMap.get(driverId);
					double driverDistanceFromSource = helper.getDistance(sourceLocation, currDriver.getLocation());
					boolean currDriverStatus = currDriver.isActive();
					if (driverDistanceFromSource <= 5 && currDriverStatus == true) {
						Ride currRide = new Ride(driverId,driverDistanceFromSource, currDriver.getVehicleDetails());
						availableDriversList.add(currRide);
					}
				}
			} else {
				throw new ResourceNotFoundException(
						"Either Source Or Destination Location is Not Valid source || destination :: "
								+ requestMap.get("sourceLocation").toString() + " || "
								+ requestMap.get("destinationLocation").toString());
			}
			Collections.sort(availableDriversList,new compare());
			return availableDriversList;
		} else {
			throw new ResourceAlreadyExist("Booking Already Exists For This Booking Id" + bookingId);
		}

	}

	@Override
	public Booking chooseRide(Map<String, Object> requestMap) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		Map<Integer, Driver> driverMap = DriverDao.driversMap;
		Map<Integer, User> userMap = UserDao.usersMap;
		Map<Integer, Booking> bookingMap =BookingDao.bookingMap;
		int bookingId = Integer.parseInt(requestMap.get("bookingId").toString());
		int driverId = Integer.parseInt(requestMap.get("driverId").toString());
		// Checking if Booking Exist or Not
		if (bookingMap.containsKey(bookingId)) {
			bookingMap.get(bookingId).setDriverId(driverId);
			double distanceOfJourney = bookingMap.get(bookingId).getJournryDistance();
			driverMap.get(bookingMap.get(bookingId).getDriverId()).setActive(false);
			driverMap.get(bookingMap.get(bookingId).getDriverId())
					.setLocation(bookingMap.get(bookingId).getDestination());
			userMap.get(bookingMap.get(bookingId).getUserId()).setLocation(bookingMap.get(bookingId).getDestination());
			bookingMap.get(bookingId).setJournryDistance(distanceOfJourney);
			return bookingMap.get(bookingId);
		} else {
			throw new ResourceNotFoundException("Booking Not Found For Provided Booking ID :: " + bookingId);
		}

	}

	@Override
	public Booking calculateBill(Map<String, Object> requestMap) throws ResourceNotFoundException {

		Map<Integer, Driver> driverMap = DriverDao.driversMap;
		Map<Integer, Booking> bookingMap =BookingDao.bookingMap;
		Helper helper = new Helper();
		int bookingId = Integer.parseInt(requestMap.get("bookingId").toString());
		if (bookingMap.containsKey(bookingId)) {
			double distanceOfJourney = helper.getDistance(bookingMap.get(bookingId).getSource(),
					bookingMap.get(bookingId).getDestination());
			bookingMap.get(bookingId).setJournryDistance(distanceOfJourney);
			bookingMap.get(bookingId).setBill((int)Math.ceil(distanceOfJourney));
			driverMap.get(bookingMap.get(bookingId).getDriverId()).setEarnings(
				(int)Math.ceil(distanceOfJourney)+ driverMap.get(bookingMap.get(bookingId).getDriverId()).getEarnings());
			return bookingMap.get(bookingId);
		}

		else {
			throw new ResourceNotFoundException("Booking Not Found For Provided Booking ID :: " + bookingId);
		}
	}

}
