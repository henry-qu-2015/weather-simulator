package com.weather.simulator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weather.simulator.service.WeatherSimulatorService;


@RestController
public class WeatherSimulatorController {
	@Autowired
	private WeatherSimulatorService weatherSimulatorService;
	
    @RequestMapping("/weather/report")
    public String home(){
        return weatherSimulatorService.getWeatherData();
    }
}
