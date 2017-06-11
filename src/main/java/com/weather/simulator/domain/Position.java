package com.weather.simulator.domain;

public class Position {
	private Double latitude;
	private Double longitude;
	private Integer elevation;
	
	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Integer getElevation() {
		return elevation;
	}

	public void setElevation(Integer elevation) {
		this.elevation = elevation;
	}

	@Override
	public String toString() {
		return latitude + "," + longitude + "," + elevation;
	}
	
}
