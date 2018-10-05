package com.apap.tutorial4.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apap.tutorial4.model.FlightModel;
import com.apap.tutorial4.repository.FlightDB;

@Service
@Transactional
public class FlightServiceImpl implements FlightService{
	@Autowired
	private FlightDB flightDb;
	
	@Override
	public void addFlight(FlightModel flight) {
		flightDb.save(flight);
	}
	

	@Override
	public void deleteFlight(Long id) {
		FlightModel flight = flightDb.findById(id).get();
		flightDb.delete(flight);
	}
	
	public FlightModel getFlightDetailById(String id) {
		return flightDb.findById(Long.parseLong(id)).get();
	}
	
	 @Override
    public void updateFlight(FlightModel flight, Long id) {
		FlightModel updatedFlight = flightDb.findById(id).get();
        updatedFlight.setDestination(flight.getDestination());
        updatedFlight.setFlightNumber(flight.getFlightNumber());
        updatedFlight.setTime(flight.getTime());
        updatedFlight.setOrigin(flight.getOrigin());
        flightDb.save(updatedFlight);
    }
	 
	@Override
    public List<FlightModel> getAllFlights(){
        return flightDb.findAll();
    }
}
