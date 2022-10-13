package com.flipfit.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.flipfit.entity.JimDetails;
import com.flipfit.entity.UserEntity;
import com.flipfit.service.IUserService;

@RestController
@RequestMapping(path = "/user")
public class UserController {
	@Autowired
	private	IUserService iUserService;
	
	@PostMapping(path = "/jim/update/{userId}")
	public @ResponseBody JimDetails updateJimDetails(@PathVariable("userId") int userId,@RequestBody JimDetails jimDetails) {
		
		return iUserService.updateJimDetails(userId,jimDetails);
		
	}
	@PostMapping("/create")
	public @ResponseBody UserEntity createUser(@RequestBody UserEntity userEntity) {
		
		return iUserService.createUser(userEntity);
			
	}
	@GetMapping(path = "/login/{userId}")
	public @ResponseBody boolean loginUser(@PathVariable("userId") int userId,@RequestBody Map<String, Object> request) {
		
		return iUserService.loginUser(userId,request);
		
	}
	@PutMapping(path = "/logout/{userId}")
	public @ResponseBody String logout(@PathVariable("userId") int userId) {
		
		return iUserService.logout(userId);
		
	}
	@GetMapping("/available/workout")
	public @ResponseBody List<HashMap<String, Integer>> viewAvailablework() {
		return iUserService.viewAvailablework();
		
	}
	@GetMapping("/book/workout/{userId}")
	public @ResponseBody String bookWorkout(@PathVariable("userId") int userId,@RequestBody Map<String, Object> request) {
		
		return iUserService.bookWorkout(userId,request);
		
	}
	@GetMapping("/all")
	public @ResponseBody List<UserEntity> getAll() {
		
		return iUserService.getAll();
		
	}
	@GetMapping("/{userId}")
	public @ResponseBody UserEntity getUser(@PathVariable("userId") int userId) {
		
		return iUserService.getUser(userId);
		
	}
	@GetMapping("/status/{userId}")
	public @ResponseBody String todayStatus(@PathVariable("userId") int userId) {
		return iUserService.todayStatus(userId);
		
	}
	
	
}
