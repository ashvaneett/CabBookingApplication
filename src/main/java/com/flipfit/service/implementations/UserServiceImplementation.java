package com.flipfit.service.implementations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.flipfit.dao.JimDao;
import com.flipfit.dao.UserDao;
import com.flipfit.entity.JimDetails;
import com.flipfit.entity.UserEntity;
import com.flipfit.service.IUserService;
@Service
public class UserServiceImplementation implements IUserService{
	HashMap<Integer, UserEntity> userHashMap=UserDao.userMap;
	HashMap<String, JimDetails> jimsHashMap=JimDao.jimsHashMap;
	@Override
	public JimDetails updateJimDetails(int userId, JimDetails jimDetails) {
		// TODO Auto-generated method stub
		if(userHashMap.get(userId).isLogin()) {
		if(userHashMap.containsKey(userId) && userHashMap.get(userId).getType().equals("admin")) {
			jimsHashMap.put(jimDetails.getJimName(), jimDetails);
			return jimDetails;
		}
		}
		return null;
	}
	@Override
	public UserEntity createUser(UserEntity userEntity) {
		// TODO Auto-generated method stub
		if(userHashMap.containsKey(userEntity.getUserId())==false) {
			userHashMap.put(userEntity.getUserId(), userEntity);
			return userHashMap.get(userEntity.getUserId());
		}
		return null;
	}
	@Override
	public boolean loginUser(int userId, Map<String, Object> request) {
		// TODO Auto-generated method stub
		
		if(userHashMap.containsKey(userId)) {
			UserEntity userEntity=userHashMap.get(userId);
			if(userEntity.isLogin()) {
				return true;
			}
			if(userEntity.getEmail().equals(request.get("email").toString()) && userEntity.getPassword().
					equals(request.get("password").toString())) {
				userEntity.setLogin(true);
				return true;
				
				
			}
		}
		return false;
	}
	@Override
	public String logout(int userId) {
		// TODO Auto-generated method stub
		if(userHashMap.containsKey(userId)) {
		if( userHashMap.get(userId).isLogin()==true) {
			userHashMap.get(userId).setLogin(false);
			return "User Logout Successfully";
		}
		else {
			return "user already logout";
		}
		}
		return "User Not Exist In The Records ";
	}
	@Override
	public List<HashMap<String, Integer>> viewAvailablework() {
		// TODO Auto-generated method stub
		List<HashMap<String, Integer>>	list=new ArrayList<>();
		list.add(jimsHashMap.get("Koramangala").getCardio());
		list.add(jimsHashMap.get("Koramangala").getWeight());
		return list;
	}
	@Override
	public String bookWorkout(int userId, Map<String, Object> request) {
		// TODO Auto-generated method stub
		if(userHashMap.containsKey(userId)) {
			if(userHashMap.get(userId).isLogin()==false) {
				return "you are not login";
			}
			String time=request.get("time").toString();
			if(request.get("type").equals("cardio")) {
				if(jimsHashMap.get("Koramangala").getCardio().get(time)>0) {
					userHashMap.get(userId).setWorkoutBooked(true);
					userHashMap.get(userId).setBookedTime(time);
					jimsHashMap.get("Koramangala").getCardio().put(time, jimsHashMap.get("Koramangala").getCardio().get(time)-1);
					return "Booked";
				}
				else {
					return "seats not available for this time ";
				}
			}
			if(request.get("type").equals("weight")) {
				if(jimsHashMap.get("Koramangala").getWeight().get(time)>0) {
					userHashMap.get(userId).setWorkoutBooked(true);
					userHashMap.get(userId).setBookedTime(time);
					jimsHashMap.get("Koramangala").getWeight().put(time, jimsHashMap.get("Koramangala").getWeight().get(time)-1);
					return "Booked";
				}
				else {
					return "seats not available for this time ";
				}
			}
		}
		return "not a valid user";
	}
	@Override
	public List<UserEntity> getAll() {
		// TODO Auto-generated method stub
		List<UserEntity> list=new ArrayList<>();
		for(int key:userHashMap.keySet()) {
			list.add(userHashMap.get(key));
		}
		return list;
	}
	@Override
	public UserEntity getUser(int userId) {
		if(userHashMap.containsKey(userId)) {
			return userHashMap.get(userId);
		}
		return null;
	}
	@Override
	public String todayStatus(int userId) {
		if(userHashMap.containsKey(userId) && userHashMap.get(userId).isWorkoutBooked()) {
			if(userHashMap.get(userId).getBookedTime()!=null) {
				return "WorkOut Booked for :--->"+userHashMap.get(userId).getBookedTime();
			}
		}
		return "You Havent Booked Slot Yet";
	}
	
	
	
	
	
}
