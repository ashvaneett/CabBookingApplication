package com.cba.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.cba.dao.DriverDao;
import com.cba.entity.Driver;
import com.cba.entity.Location;
import com.cba.exception.ResourceAlreadyExist;
import com.cba.exception.ResourceNotFoundException;
import com.cba.service.DriverService;

@Service
public class DriverServiceImpl implements DriverService {

	@Override
	public Driver createDriver(Driver newDriver) throws ResourceAlreadyExist {
		Map<Integer, Driver> driversMap = DriverDao.driversMap;

		if (!driversMap.containsKey(newDriver.getDriverId())) {
			driversMap.put(newDriver.getDriverId(), newDriver);
			return driversMap.get(newDriver.getDriverId());
		} else {
			throw new ResourceAlreadyExist("The Driver Already Exists For This ID :: " + newDriver.getDriverId());
		}

	}

	@Override
	public Driver getDriver(Map<String, Object> request) throws ResourceNotFoundException {
		// TODO Auto-generated method stub

		Map<Integer, Driver> driversMap = DriverDao.driversMap;
		int driverId = Integer.parseInt(request.get("driverId").toString());
		if (driversMap.containsKey(driverId)) {
			return driversMap.get(driverId);
		} else {
			throw new ResourceNotFoundException("Driver Not Found For This DriverId :: " + driverId);
		}

	}

	@Override
	public Driver updateDriverStatus(Map<String, Object> request) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		Map<Integer, Driver> driversMap = DriverDao.driversMap;
		int driverId = Integer.parseInt(request.get("driverId").toString());
		if (driversMap.containsKey(driverId)) {

			if (request.get("status").toString().equals("ACTIVE")) {
				driversMap.get(driverId).setActive(true);
			} else {
				driversMap.get(driverId).setActive(false);
			}
			return driversMap.get(driverId);
		}

		else {
			throw new ResourceNotFoundException("Driver Not Found For This DriverId :: " + driverId);
		}
	}

	@Override
	public List<Driver> getAllDrivers() throws ResourceNotFoundException {
		// TODO Auto-generated method stub

		Map<Integer, Driver> driversMap = DriverDao.driversMap;
		List<Driver> driversList = new ArrayList<>();
		for (int id : driversMap.keySet()) {
			driversList.add(driversMap.get(id));
		}
		if (driversList.size() > 0) {
			return driversList;
		} else {
			throw new ResourceNotFoundException("No Any Driver Found In The App ::" + "ADD_DRIVERS");
		}

	}

	@Override
	public Driver updateDriverLocation(Map<String, Object> request) throws ResourceNotFoundException {

		Map<Integer, Driver> driversMap = DriverDao.driversMap;
		int driverId = Integer.parseInt(request.get("driverId").toString());
		if (driversMap.containsKey(driverId)) {
			Map<String, Object> locationMap = (Map<String, Object>) request.get("location");
			driversMap.get(driverId).setLocation(new Location(Integer.parseInt(locationMap.get("x").toString()),
					Integer.parseInt(locationMap.get("y").toString())));
			return driversMap.get(driverId);
		} else {
			throw new ResourceNotFoundException("Driver Not Found For This DriverId :: " + driverId);
		}

	}

	@Override
	public Driver updateDriverDetails(Map<String, Object> request) throws ResourceNotFoundException {
		Map<Integer, Driver> driversMap = DriverDao.driversMap;
		int driverId = Integer.parseInt(request.get("driverId").toString());
		if (driversMap.containsKey(driverId)) {
			if (request.containsKey("mobileNumber")) {
				driversMap.get(driverId).setMobileNumber(request.get("mobileNumber").toString());
			}
			if (request.containsKey("emailId")) {
				driversMap.get(driverId).setEmailId(request.get("emailId").toString());
			}
			return driversMap.get(driverId);
		}

		else {
			throw new ResourceNotFoundException("Driver Not Found For This DriverId :: " + driverId);
		}

	}

	@Override
	public Driver removeDriver(Map<String, Object> request) throws ResourceNotFoundException {

		Map<Integer, Driver> driversMap = DriverDao.driversMap;
		int driverId = Integer.parseInt(request.get("driverId").toString());
		if (driversMap.containsKey(driverId)) {
			return driversMap.remove(driverId);
		}

		else {
			throw new ResourceNotFoundException("Driver Not Found For This DriverId :: " + driverId);
		}
	}

	@Override
	public Map<String, Integer> getEarningsOfDrivers() throws ResourceNotFoundException {

		Map<Integer, Driver> driversMap = DriverDao.driversMap;
		Map<String, Integer> driverEarningMap = new HashMap<>();

		for (int driverId : driversMap.keySet()) {
			driverEarningMap.put(driversMap.get(driverId).getDriverName(), driversMap.get(driverId).getEarnings());
		}
		if (driverEarningMap.size() > 0) {
			return driverEarningMap;
		} else {
			throw new ResourceNotFoundException("No Any Driver Found In The App ::" + "ADD_DRIVERS");
		}

	}

}
