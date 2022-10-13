package com.flipfit.entity;

import java.util.HashMap;

public class JimDetails {

	private String jimName;
	private HashMap<String, Integer> cardio = new HashMap<>();
	private HashMap<String, Integer> weight = new HashMap<>();

	public JimDetails(String jimName, HashMap<String, Integer> cardio, HashMap<String, Integer> weight) {
		super();
		this.jimName = jimName;
		this.cardio = cardio;
		this.weight = weight;
	}

	public JimDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getJimName() {
		return jimName;
	}

	public void setJimName(String jimName) {
		this.jimName = jimName;
	}

	public HashMap<String, Integer> getCardio() {
		return cardio;
	}

	public void setCardio(HashMap<String, Integer> cardio) {
		this.cardio = cardio;
	}

	public HashMap<String, Integer> getWeight() {
		return weight;
	}

	public void setWeight(HashMap<String, Integer> weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "JimDetails [jimName=" + jimName + ", cardio=" + cardio + ", weight=" + weight + "]";
	}

}
