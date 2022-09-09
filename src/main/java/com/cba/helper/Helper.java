package com.cba.helper;

import org.springframework.stereotype.Component;

import com.cba.entity.Location;

@Component
public class Helper {
	public double getDistance(Location a,Location b) {
		int x=a.getX()-b.getX();
		int y=a.getY()-b.getY();
		return Math.sqrt(x*x+y*y);
	}
	
}
