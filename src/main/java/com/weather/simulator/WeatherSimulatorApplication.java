package com.weather.simulator;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;


import com.weather.simulator.domain.Location;
import com.weather.simulator.domain.Position;

@SpringBootApplication
@EnableCaching
public class WeatherSimulatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherSimulatorApplication.class, args);
	}
	
	@Bean(name = "locations")
	public List<Location> Locations() {
		List<Location> locations = new ArrayList<>();
		Location location = new Location();
		Position position = new Position();
		
		//Sydney
		position.setLatitude(-33.86);
		position.setLongitude(151.21);
		position.setElevation(39);
		location.setName("Sydney");
		location.setPosition(position);
		location.setZone(ZoneId.SHORT_IDS.get("AET"));
		locations.add(location);
		
		location = new Location();
		position = new Position();
		
		//Melbourne
		position.setLatitude(-37.83);
		position.setLongitude(144.98);
		position.setElevation(7);
		location.setName("Melbourne");
		location.setPosition(position);
		location.setZone(ZoneId.SHORT_IDS.get("AET"));
		locations.add(location);
		
		location = new Location();
		position = new Position();
		
		//New York
		position.setLatitude(40.71);
		position.setLongitude(74.01);
		position.setElevation(10);
		location.setName("New York");
		location.setPosition(position);
		location.setZone("America/New_York");
		locations.add(location);
		
		location = new Location();
		position = new Position();
		
		//London
		position.setLatitude(51.51);
		position.setLongitude(0.13);
		position.setElevation(35);
		location.setName("London");
		location.setPosition(position);
		location.setZone("Europe/London");
		locations.add(location);
		
		location = new Location();
		position = new Position();
		
		//Berlin
		position.setLatitude(52.52);
		position.setLongitude(13.41);
		position.setElevation(34);
		location.setName("Berlin");
		location.setPosition(position);
		location.setZone("Europe/Berlin");
		locations.add(location);
		
		location = new Location();
		position = new Position();
		
		//Paris
		position.setLatitude(48.86);
		position.setLongitude(2.35);
		position.setElevation(35);
		location.setName("London");
		location.setPosition(position);
		location.setZone("Europe/Paris");
		locations.add(location);
		
		location = new Location();
		position = new Position();
		
		//Rome
		position.setLatitude(41.90);
		position.setLongitude(12.50);
		position.setElevation(24);
		location.setName("London");
		location.setPosition(position);
		location.setZone("Europe/Rome");
		locations.add(location);
		
		location = new Location();
		position = new Position();
		
		//Tokyo
		position.setLatitude(35.69);
		position.setLongitude(139.69);
		position.setElevation(40);
		location.setName("Tokyo");
		location.setPosition(position);
		location.setZone("Asia/Tokyo");
		locations.add(location);
		
		location = new Location();
		position = new Position();
		
		//Beijing
		position.setLatitude(39.90);
		position.setLongitude(116.41);
		position.setElevation(44);
		location.setName("Beijing");
		location.setPosition(position);
		location.setZone("Asia/Shanghai");
		locations.add(location);
		
		location = new Location();
		position = new Position();
		
		//Tasmania
		position.setLatitude(-41.45);
		position.setLongitude(145.97);
		position.setElevation(209);
		location.setName("Tasmania");
		location.setPosition(position);
		location.setZone("Australia/Tasmania");
		locations.add(location);
		
		location = new Location();
		position = new Position();
		return locations;
	}
	
}
