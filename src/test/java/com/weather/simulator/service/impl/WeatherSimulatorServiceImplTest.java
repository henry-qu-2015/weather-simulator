package com.weather.simulator.service.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.weather.simulator.WeatherSimulatorApplication;
import com.weather.simulator.service.WeatherSimulatorService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WeatherSimulatorApplication.class})
public class WeatherSimulatorServiceImplTest{


	@Autowired
	WeatherSimulatorService weatherSimulatorService;


	@Test
	public void should_return_report() {
		String report = weatherSimulatorService.getWeatherData();
		assertTrue(report != null);
	}

}
