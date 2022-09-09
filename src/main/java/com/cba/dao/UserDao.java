package com.cba.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.cba.entity.User;

@Component
public class UserDao{
	public static Map<Integer, User> usersMap=new HashMap<>();

}
