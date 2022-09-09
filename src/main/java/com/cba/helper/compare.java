package com.cba.helper;

import java.util.Comparator;

import com.cba.entity.Ride;

public class compare implements Comparator<Ride> {

	@Override
	public int compare(Ride ride1, Ride ride2) {
		// TODO Auto-generated method stub
		return (int)(ride1.getDriverApartFromSource()-ride2.getDriverApartFromSource());
	}

}
