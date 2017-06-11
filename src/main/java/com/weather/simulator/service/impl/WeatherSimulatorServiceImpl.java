package com.weather.simulator.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import com.weather.simulator.domain.Location;
import com.weather.simulator.domain.WeatherEntry;
import com.weather.simulator.service.WeatherSimulatorService;
import com.weather.simulator.utils.WeatherSimulatorUtil;
@Service
@PropertySource("classpath:global.properties")
public class WeatherSimulatorServiceImpl implements WeatherSimulatorService {
	@Autowired
	@Qualifier("locations")
	private List<Location> locations;
	@Autowired
	private WeatherSimulatorUtil weatherSimulatorUtil;
	@Value("${line-separator}")
	private String lineSeparator;

	@Override
	@Cacheable(value = "weatherData")
	public String getWeatherData() {
		List<WeatherEntry> weatherEntries = getWeatherEntries(locations);
		String breaker = "".equals(lineSeparator) ? System.getProperty("line.separator") : lineSeparator;
		StringBuffer sb = new StringBuffer();
		for (WeatherEntry weatherEntry : weatherEntries) {
			sb.append(weatherEntry.toString()).append(breaker);
		}
		return sb.substring(0, sb.length() - breaker.length());
	}
	
	private List<WeatherEntry> getWeatherEntries (List<Location> locations) {
		List<WeatherEntry> weatherEntries = new ArrayList<WeatherEntry>();
		WeatherEntry  weatherEntry = new WeatherEntry();
		for (Location location : locations) {
			weatherEntry.setLocation(location);
			weatherEntry.setLocalTime(weatherSimulatorUtil.getLocationTime(location.getZone()));
			weatherEntry.setCondition(weatherSimulatorUtil.getLocationCondition(weatherEntry.getLocalTime(), weatherEntry.getLocation()));
			weatherEntry.setTemperature(weatherSimulatorUtil.getTemperature(weatherEntry.getCondition()));
			weatherEntry.setPressure(weatherSimulatorUtil.getPressure(weatherEntry.getCondition()));
			weatherEntry.setHumidity(weatherSimulatorUtil.getHumidity(weatherEntry.getCondition()));
			weatherEntries.add(weatherEntry);
			weatherEntry = new WeatherEntry();
		}

		return weatherEntries;
	}
	

}
