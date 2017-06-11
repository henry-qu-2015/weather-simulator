package com.weather.simulator.domain;

public enum Conditions {
	RAIN("Rain"),
	SNOW("Snow"),
	SUNNY("Sunny");
	
	private String condition;
	
	Conditions (String condition) {
		this.condition = condition;
	}
	public String condition() {
		return condition;
	}
}
