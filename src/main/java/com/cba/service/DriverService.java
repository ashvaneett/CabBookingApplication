package com.cba.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cba.entity.Driver;
import com.cba.exception.ResourceAlreadyExist;
import com.cba.exception.ResourceNotFoundException;

@Repository
public interface DriverService {

	Driver createDriver(Driver newDriver) throws ResourceAlreadyExist;

	Driver getDriver(Map<String, Object> request) throws ResourceNotFoundException;

	Driver updateDriverStatus(Map<String, Object> request) throws ResourceNotFoundException;

	List<Driver> getAllDrivers() throws ResourceNotFoundException;

	Driver updateDriverLocation(Map<String, Object> request) throws ResourceNotFoundException;

	Driver updateDriverDetails(Map<String, Object> request) throws ResourceNotFoundException;

	Driver removeDriver(Map<String, Object> request) throws ResourceNotFoundException;

	Map<String, Integer> getEarningsOfDrivers() throws ResourceNotFoundException;

}
