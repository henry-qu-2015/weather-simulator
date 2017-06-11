package com.weather.simulator.utils;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.weather.simulator.WeatherSimulatorApplication;
import com.weather.simulator.domain.Conditions;
import com.weather.simulator.domain.Location;
import com.weather.simulator.domain.Position;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WeatherSimulatorApplication.class})
public class WeatherSimulatorUtilTest {
	@Autowired
	WeatherSimulatorUtil weatherSimulatorUtil;
	

	@Test
	public void should_return_no_snow_for_latitude_less_than_30_and_greater_than_minus_40() {
		LocalDateTime localDateTime = LocalDateTime.now();
		Location location = new Location();
		Position position = new Position();
		position.setLatitude(25.36);
		location.setPosition(position);
		Conditions condition = weatherSimulatorUtil.getLocationCondition(localDateTime, location);
		assertFalse(Conditions.SNOW.equals(condition));
		location.getPosition().setLatitude(-39.26);
		condition = weatherSimulatorUtil.getLocationCondition(localDateTime, location);
		assertFalse(Conditions.SNOW.equals(condition));
	}
	
	@Test
	public void should_return_no_snow_for_latitude_greater_than_30_from_march_to_steptember() {
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime localDateTime = LocalDateTime.of(now.getYear(), 8, now.getDayOfMonth(), now.getHour(), now.getMinute());
		Location location = new Location();
		Position position = new Position();
		position.setLatitude(35.36);
		location.setPosition(position);
		Conditions condition = weatherSimulatorUtil.getLocationCondition(localDateTime, location);
		assertFalse(Conditions.SNOW.equals(condition));
	}
	
	@Test
	public void should_return_no_snow_for_latitude_less_than_minus_40_from_steptember_to_may() {
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime localDateTime = LocalDateTime.of(now.getYear(), 11, now.getDayOfMonth(), now.getHour(), now.getMinute());
		Location location = new Location();
		Position position = new Position();
		position.setLatitude(-45.36);
		location.setPosition(position);
		Conditions condition = weatherSimulatorUtil.getLocationCondition(localDateTime, location);
		assertFalse(Conditions.SNOW.equals(condition));
	}
	
	@Test
	public void should_return_one_of_all_conditions_for_rest_cases() {
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime localDateTime = LocalDateTime.of(now.getYear(), 10, now.getDayOfMonth(), now.getHour(), now.getMinute());
		Location location = new Location();
		Position position = new Position();
		position.setLatitude(45.36);
		location.setPosition(position);
		Conditions condition = weatherSimulatorUtil.getLocationCondition(localDateTime, location);
		assertTrue(Conditions.SNOW.equals(condition) || Conditions.RAIN.equals(condition) || Conditions.SUNNY.equals(condition));
	}

	@Test
	public void should_return_temperature_from_5_to_15_if_rain() {
		float temperature = weatherSimulatorUtil.getTemperature(Conditions.RAIN);
		assertTrue(temperature >=5 && temperature<=15);
	}

	@Test
	public void should_return_temperature_from_16_to_45_if_sunny() {
		float temperature = weatherSimulatorUtil.getTemperature(Conditions.SUNNY);
		assertTrue(temperature >=16 && temperature<=45);
	}
	
	@Test
	public void should_return_temperature_from_minus_5_to_minus_45_if_snow() {
		float temperature = weatherSimulatorUtil.getTemperature(Conditions.SNOW);
		assertTrue(temperature >=-45 && temperature<=-5);
	}

	@Test
	public void should_return_humidity_from_71_to_99_if_rain() {
		int humidity = weatherSimulatorUtil.getHumidity(Conditions.RAIN);
		assertTrue(humidity >=71 && humidity<=99);
	}
	
	@Test
	public void should_return_humidity_from_10_to_30_if_sunny() {
		int humidity = weatherSimulatorUtil.getHumidity(Conditions.SUNNY);
		assertTrue(humidity >=10 && humidity<=30);
	}
	
	@Test
	public void should_return_humidity_from_31_to_70_if_snow() {
		int humidity = weatherSimulatorUtil.getHumidity(Conditions.SNOW);
		assertTrue(humidity >=31 && humidity<=70);
	}
	
	@Test
	public void should_return_pressure_from_1000_to_1099_if_rain() {
		float pressure = weatherSimulatorUtil.getPressure(Conditions.RAIN);
		assertTrue(pressure >=1000 && pressure<=1099);
	}
	
	@Test
	public void should_return_pressure_from_900_to_999_if_sunny() {
		float pressure = weatherSimulatorUtil.getPressure(Conditions.SUNNY);
		assertTrue(pressure >=900 && pressure<=999);
	}
	
	@Test
	public void should_return_pressure_from_1100_to_1200_if_snow() {
		float pressure = weatherSimulatorUtil.getPressure(Conditions.SNOW);
		assertTrue(pressure >=1100 && pressure<=1200);
	}

}
