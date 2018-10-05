package com.apap.tutorial4.service;

import java.util.List;

import com.apap.tutorial4.model.FlightModel;

public interface FlightService {
	FlightModel getFlightDetailById(String id);
	void addFlight(FlightModel flight);
	void deleteFlight(Long id);
	void updateFlight(FlightModel flight, Long id);
	List<FlightModel> getAllFlights();
	
}
