package com.apap.tutorial4.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apap.tutorial4.model.PilotModel;
import com.apap.tutorial4.repository.PilotDB;

@Service
@Transactional
public class PilotServiceImpl implements PilotService{
	@Autowired
	private PilotDB pilotDb;
	
	@Override
	public PilotModel getPilotDetailByLicenseNumber(String licenseNumber) {
		return pilotDb.findByLicenseNumber(licenseNumber);
	}
	
	@Override
	public void addPilot(PilotModel pilot) {
		pilotDb.save(pilot);
	}

	@Override
	public void deletePilot(PilotModel pilot) {
		pilotDb.delete(pilot);
	}

	@Override
	public void updatePilot(PilotModel pilot, String licenseNumber) {
	    PilotModel updatedPilot = pilotDb.findByLicenseNumber(licenseNumber);
	    updatedPilot.setName(pilot.getName());
	    updatedPilot.setFlyHour(pilot.getFlyHour());
	    pilotDb.save(updatedPilot);
	}

}
