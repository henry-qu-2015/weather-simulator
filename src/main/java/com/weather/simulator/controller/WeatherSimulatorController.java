package com.weather.simulator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weather.simulator.service.WeatherSimulatorService;


@RestController
public class WeatherSimulatorController {
	@Autowired
	private WeatherSimulatorService weatherSimulatorService;
	
    @GetMapping("/weather/report")
    public String getWeatherReport(){
        return weatherSimulatorService.getWeatherData();
    }
}
