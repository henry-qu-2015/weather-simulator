package com.weather.simulator.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.weather.simulator.domain.Conditions;
import com.weather.simulator.domain.Location;

@Service
public class WeatherSimulatorUtil {
	private static final List<Conditions> fullConditions = Arrays.asList(Conditions.values());
	private static final List<Conditions> limitConditions = Arrays.asList(Conditions.RAIN,Conditions.SUNNY);
	private static final Random random = new Random();
	private static final float MIN_RAIN_TEMPRATURE = 5.0f;
	private static final float MAX_RAIN_TEMPRATURE = 15.0f;
	private static final float MIN_SUNNY_TEMPRATURE = 16.0f;
	private static final float MAX_SUNNY_TEMPRATURE = 45.0f;
	private static final float MIN_SNOW_TEMPRATURE = -45.0f;
	private static final float MAX_SNOW_TEMPRATURE = -5.0f;
	private static final int LOW_RAIN_HUMIDITY = 71;
	private static final int HIGH_RAIN_HUMIDITY = 99;
	private static final int LOW_SUNNY_HUMIDITY = 10;
	private static final int HIGH_SUNNY_HUMIDITY = 30;
	private static final int LOW_SNOW_HUMIDITY = 31;
	private static final int HIGH_SNOW_HUMIDITY = 70;
	private static final float LOW_RAIN_PRESSURE = 1000.0f;
	private static final float HIGH_RAIN_PRESSURE = 1099.0f;
	private static final float LOW_SUNNY_PRESSURE = 900.0f;
	private static final float HIGH_SUNNY_PRESSURE = 999.0f;
	private static final float LOW_SNOW_PRESSURE = 1100.0f;
	private static final float HIGH_SNOW_PRESSURE = 1200.0f;
	public Conditions getLocationCondition(LocalDateTime localTime, Location location) {
		int month = localTime.getMonth().getValue();
		double latitude = location.getPosition().getLatitude();
		//if city in north hemisphere and latitude greater than 30 and month between 1-3 or 10-12
		//or in south hemisphere and latitude less than -40 and month between 6-8 
		//there will be snow condition. for rest of world and months, no snow
		if ((latitude >30) && ((month <= 3 && month >=1) || (month >= 10)) || (latitude <= -40 && (month >= 6 && month <= 8))) {
			return getRandomCondition(false);		
		} else {
			return getRandomCondition(true);
		}
		
	}
	private  Conditions getRandomCondition(boolean isLimited) {
		if (isLimited) {
			return limitConditions.get(random.nextInt(limitConditions.size()));
		} else {
			return fullConditions.get(random.nextInt(fullConditions.size()));
		}
	}
	public  Float getTemperature(Conditions condition) {
		if (Conditions.RAIN.equals(condition)) {
			return random.nextFloat() * (MAX_RAIN_TEMPRATURE - MIN_RAIN_TEMPRATURE) + MIN_RAIN_TEMPRATURE;
		} else if (Conditions.SUNNY.equals(condition)) {
			return random.nextFloat() * (MAX_SUNNY_TEMPRATURE - MIN_SUNNY_TEMPRATURE) + MIN_SUNNY_TEMPRATURE;

		} else {
			return random.nextFloat() * (MAX_SNOW_TEMPRATURE - MIN_SNOW_TEMPRATURE) + MIN_SNOW_TEMPRATURE;
		}

	}
	
	public  LocalDateTime getLocationTime(String zone) {
		ZoneId zoneId = ZoneId.of(zone);
		return LocalDateTime.now(zoneId);

	}
	
	public  Integer getHumidity(Conditions condition) {
		if (Conditions.RAIN.equals(condition)) {
			return random.nextInt((HIGH_RAIN_HUMIDITY - LOW_RAIN_HUMIDITY) + 1) + LOW_RAIN_HUMIDITY;
		} else if (Conditions.SUNNY.equals(condition)) {
			return random.nextInt((HIGH_SUNNY_HUMIDITY - LOW_SUNNY_HUMIDITY) + 1) + LOW_SUNNY_HUMIDITY;
		} else {
			return random.nextInt((HIGH_SNOW_HUMIDITY - LOW_SNOW_HUMIDITY) + 1) + LOW_SNOW_HUMIDITY;
		}

	}

	public  Float getPressure(Conditions condition) {
		if (Conditions.RAIN.equals(condition)) {
			return random.nextFloat() * (HIGH_RAIN_PRESSURE - LOW_RAIN_PRESSURE) + LOW_RAIN_PRESSURE;
		} else if (Conditions.SUNNY.equals(condition)) {
			return random.nextFloat() * (HIGH_SUNNY_PRESSURE - LOW_SUNNY_PRESSURE) + LOW_SUNNY_PRESSURE;

		} else {
			return random.nextFloat() * (HIGH_SNOW_PRESSURE - LOW_SNOW_PRESSURE) + LOW_SNOW_PRESSURE;
		}
	}
}
