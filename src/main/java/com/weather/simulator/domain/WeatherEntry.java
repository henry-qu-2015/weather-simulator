package com.weather.simulator.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class WeatherEntry {
	private Location location;
	private LocalDateTime localTime;
	private Conditions condition;
	private Float temperature;
	private Float pressure;
	private Integer humidity;
	private DecimalFormat df = new DecimalFormat("#.00"); 
	public Float getTemperature() {
		return getRoundUpFloatWithTwoDecimal(temperature);
	}
	public void setTemperature(Float temperature) {
		this.temperature = temperature;
	}
	public Float getPressure() {
		return getRoundUpFloatWithTwoDecimal(pressure);
	}
	public void setPressure(Float pressure) {
		this.pressure = pressure;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}

	public LocalDateTime getLocalTime() {
		return localTime;
	}
	public void setLocalTime(LocalDateTime localTime) {
		this.localTime = localTime;
	}
	public Conditions getCondition() {
		return condition;
	}
	public void setCondition(Conditions condition) {
		this.condition = condition;
	}

	public Integer getHumidity() {
		return humidity;
	}
	public void setHumidity(Integer humidity) {
		this.humidity = humidity;
	}
	public String getLocalTimeString () {
		ZoneId zoneId = ZoneId.of(this.location.getZone());
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		return LocalDateTime.now(zoneId).format(formatter);
	}
	@Override
	public String toString() {
		return  location.toString() +  "|" + getLocalTimeString()
				+ "|" + condition.condition() + "|" + (getTemperature() > 0 ? "+" + getTemperature() : getTemperature())
					+ "|" + getPressure() + "|" + humidity;
	}
	

	private Float getRoundUpFloatWithTwoDecimal(Float number) {
		BigDecimal value = new BigDecimal(number);
		value = value.setScale(2, RoundingMode.HALF_EVEN);
		return value.floatValue();
	}
	
}
