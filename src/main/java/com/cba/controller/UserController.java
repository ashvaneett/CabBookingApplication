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

import com.cba.entity.User;
import com.cba.exception.ResourceAlreadyExist;
import com.cba.exception.ResourceNotFoundException;
import com.cba.service.UsersService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class UserController {

	@Autowired
	private UsersService usersService;

	/**
	 * 
	 * @param newUser
	 * @return user if created else null
	 */
	@PostMapping(path = "/user/create")
	public @ResponseBody User createNewUser(@RequestBody User newUser) throws ResourceAlreadyExist {
		return usersService.createNewUser(newUser);
	}

	/**
	 * 
	 * @return List of all registered users
	 */
	@GetMapping(path = "/user/users")
	public @ResponseBody List<User> getAllUsers() throws ResourceNotFoundException {
		return usersService.getAllUsers();
	}

	/**
	 * this api will update the given details if user will found if user will not
	 * found it will create new User
	 * 
	 * @param requestMap
	 * @return updated user details
	 */
	@PutMapping(path = "/user/update")
	public @ResponseBody User updateUser(@RequestBody Map<String, Object> requestMap) throws ResourceNotFoundException {

		return usersService.updateUser(requestMap);

	}

	/**
	 * it will returns the updated location of entity if user exist else it will
	 * create new entity user with that updated Location
	 * 
	 * @param requestMap
	 * @return User Entity
	 */
	@PutMapping(path = "/user/update/location")
	public @ResponseBody User updateUserLocation(@RequestBody Map<String, Object> requestMap)
			throws ResourceNotFoundException {

		return usersService.updateUserLocation(requestMap);

	}

	/**
	 * this will return user details if present else return null
	 * 
	 * @param userName
	 * @return
	 */
	@GetMapping(path = "/user/user")
	public @ResponseBody User getUser(@RequestBody Map<String, Object> requestMap) throws ResourceNotFoundException {

		return usersService.getUser(requestMap);
	}

	/**
	 * delete user if exist
	 * 
	 * @param userName
	 * @return user details that deleted from records
	 */
	@DeleteMapping(path = "/user/delete")
	public @ResponseBody User removeUser(@RequestBody Map<String, Object> requestMap) throws ResourceNotFoundException {

		return usersService.removeUser(requestMap);

	}

}
