package com.weather.simulator.controller;


import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


public class WeatherSimulatorControllerTest {
	
	private static MockMvc mockMvc;
	@Mock
	static WeatherSimulatorController weatherSimulatorController;
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(weatherSimulatorController).build(); 
		when(weatherSimulatorController.getWeatherReport()).thenReturn("report");
	}

	@Test
	public void should_return_not_allow_for_none_get_method() throws Exception { 
		   mockMvc.perform(post("/weather/report")).andExpect(status().isMethodNotAllowed());   
	}
	
	@Test
	public void should_return_success_for_get_method() throws Exception { 		
		mockMvc.perform(get("/weather/report")).andExpect(status().isOk());		   
	}

}
