package com.flipfit.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.flipfit.entity.JimDetails;
import com.flipfit.entity.UserEntity;

@Repository
public interface IUserService {

	JimDetails updateJimDetails(int userId, JimDetails jimDetails);

	UserEntity createUser(UserEntity userEntity);

	boolean loginUser(int userId, Map<String, Object> request);

	String logout(int userId);

	List<HashMap<String, Integer>> viewAvailablework();

	String bookWorkout(int userId, Map<String, Object> request);

	List<UserEntity> getAll();

	UserEntity getUser(int userId);

	String todayStatus(int userId);

}
