package com.cba.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.cba.dao.UserDao;
import com.cba.entity.Location;
import com.cba.entity.User;
import com.cba.exception.ResourceAlreadyExist;
import com.cba.exception.ResourceNotFoundException;
import com.cba.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService {

	@Override
	public User createNewUser(User newUser) throws ResourceAlreadyExist {

		Map<Integer, User> userMap = UserDao.usersMap;
		if (!userMap.containsKey(newUser.getUserId())) {
			userMap.put(newUser.getUserId(), newUser);
			return userMap.get(newUser.getUserId());
		} else {
			throw new ResourceAlreadyExist("The User is Already Exist for this ID :: " + newUser.getUserId());
		}
	}

	@Override
	public List<User> getAllUsers() throws ResourceNotFoundException {

		Map<Integer, User> userMap = UserDao.usersMap;
		List<User> users = new ArrayList<>();
		for (int id : userMap.keySet()) {
			users.add(userMap.get(id));
		}
		if (users.size() > 0) {
			return users;
		} else {
			throw new ResourceNotFoundException("No Any User Exist in App right Now :: " + "ADD_USERS");
		}

	}

	@Override
	public User updateUser(Map<String, Object> requestMap) throws ResourceNotFoundException {

		Map<Integer, User> userMap = UserDao.usersMap;
		// fetching userName from request
		int userId = Integer.parseInt(requestMap.get("userId").toString());
		// init the user
		if (userMap.containsKey(userId)) {
			if (requestMap.containsKey("phoneNumber")) {
				userMap.get(userId).setPhoneNumber(requestMap.get("phoneNumber").toString());
			}
			if (requestMap.containsKey("emailId")) {
				userMap.get(userId).setEmailId(requestMap.get("emailId").toString());
			}
			return userMap.get(userId);
		} else {
			throw new ResourceNotFoundException("User Not Found For This ID :: " + userId);
		}

	}

	@Override
	public User updateUserLocation(Map<String, Object> requestMap) throws ResourceNotFoundException {

		Map<Integer, User> userMap = UserDao.usersMap;
		// fetching userName from request
		int userId = Integer.parseInt(requestMap.get("userId").toString());
		// init the user
		if (userMap.containsKey(userId)) {
			if (requestMap.containsKey("location")) {
				Map<String, Object> locationMap = (Map<String, Object>) requestMap.get("location");
				userMap.get(userId).setLocation(new Location(Integer.parseInt(locationMap.get("x").toString()),
						Integer.parseInt(locationMap.get("y").toString())));
			}
			return userMap.get(userId);
		} else {
			throw new ResourceNotFoundException("User Not Found For This ID :: " + userId);
		}
	}

	@Override
	public User getUser(Map<String, Object> requestMap) throws ResourceNotFoundException {

		Map<Integer, User> userMap = UserDao.usersMap;
		// fetching userName from request
		int userId = Integer.parseInt(requestMap.get("userId").toString());
		if (userMap.containsKey(userId)) {
			return userMap.get(userId);
		} else {
			throw new ResourceNotFoundException("User Not Found For This ID :: " + userId);
		}

	}

	@Override
	public User removeUser(Map<String, Object> requestMap) throws ResourceNotFoundException {

		Map<Integer, User> userMap = UserDao.usersMap;
		// fetching userName from request
		int userId = Integer.parseInt(requestMap.get("userId").toString());
		if (userMap.containsKey(userId)) {

			return userMap.remove(userId);

		} else {
			throw new ResourceNotFoundException("User Not Found For This ID :: " + userId);
		}

	}

}
