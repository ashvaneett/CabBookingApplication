package com.cba.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.cba.entity.Driver;
@Component
public class DriverDao {
  public static Map<Integer, Driver> driversMap=new HashMap<>();

}
