package com.cba.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cba.entity.Driver;
import com.cba.exception.ResourceAlreadyExist;
import com.cba.exception.ResourceNotFoundException;
import com.cba.service.DriverService;

@RestController
public class DriverController {
	@Autowired
	private DriverService driverService;

	/**
	 * this method will create new user and add to the Driver dao member List
	 * 
	 * @param newDriver
	 * @return this API return the driver After the successful creation of the
	 *         driver else return the null
	 */
	@PostMapping(path = "/driver/create")
	public @ResponseBody Driver createDriver(@RequestBody Driver newDriver) throws ResourceAlreadyExist {

		return driverService.createDriver(newDriver);

	}

	/**
	 * this API will return if Driver Exist else return null
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(path = "/driver/get")
	public @ResponseBody Driver getDriver(@RequestBody Map<String, Object> request) throws ResourceNotFoundException {
		return driverService.getDriver(request);

	}

	/**
	 * this API returns all registered drivers on the plat form
	 * 
	 * @return list of all drivers else empty list
	 */
	@GetMapping(path = "/driver/all")
	public @ResponseBody List<Driver> getAllDrivers() throws ResourceNotFoundException {
		return driverService.getAllDrivers();

	}

	/**
	 * this API will update status of the driver whether it is active or Inactive
	 * 
	 * @param request{possible values of request is Active ,Inactive}
	 * @return return updated Driver
	 */
	@PutMapping(path = "/driver/update/status")
	public @ResponseBody Driver updateDriverStatus(@RequestBody Map<String, Object> request)
			throws ResourceNotFoundException {

		return driverService.updateDriverStatus(request);

	}

	@PutMapping(path = "/driver/update/location")
	public @ResponseBody Driver updateDriverLocation(@RequestBody Map<String, Object> request)
			throws ResourceNotFoundException {
		return driverService.updateDriverLocation(request);
	}

	/**
	 * this API can update any details of driver
	 * 
	 * @param request { contains id and details that want to update }
	 * @return updated driver
	 */
	@PutMapping(path = "/driver/update/details")
	public @ResponseBody Driver updateDriverDetails(@RequestBody Map<String, Object> request)
			throws ResourceNotFoundException {
		return driverService.updateDriverDetails(request);

	}

	/**
	 * this API will remove user if exist
	 * 
	 * @param request
	 * @return possible Value {deleted,Not FOUND}
	 */
	@DeleteMapping(path = "/driver/remove")
	public @ResponseBody Driver removeDriver(@RequestBody Map<String, Object> request)
			throws ResourceNotFoundException {
		return driverService.removeDriver(request);

	}

	/**
	 * This API will return the earnings of all drivers
	 * 
	 * @return return the list of available drivers
	 */
	@GetMapping(path = "/driver/all/earnings")
	public @ResponseBody Map<String, Integer> getEarningsOfDrivers() throws ResourceNotFoundException {

		return driverService.getEarningsOfDrivers();

	}

}
