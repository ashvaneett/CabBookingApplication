package com.cba.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cba.entity.User;
import com.cba.exception.ResourceAlreadyExist;
import com.cba.exception.ResourceNotFoundException;

@Repository
public interface UsersService {

	public User createNewUser(User newUser) throws ResourceAlreadyExist;

	public List<User> getAllUsers() throws ResourceNotFoundException;

	public User updateUser(Map<String, Object> requestMap) throws ResourceNotFoundException;

	public User updateUserLocation(Map<String, Object> requestMap) throws ResourceNotFoundException;

	public User getUser(Map<String, Object> requestMap) throws ResourceNotFoundException;

	public User removeUser(Map<String, Object> requestMap) throws ResourceNotFoundException;
}
