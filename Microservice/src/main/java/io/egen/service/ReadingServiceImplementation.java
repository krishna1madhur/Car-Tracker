package io.egen.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.entity.Alert;
import io.egen.entity.Reading;
import io.egen.entity.Vehicle;
import io.egen.exception.BadRequestException;
import io.egen.exception.ResourceNotFoundException;
import io.egen.repository.ReadingRepository;


@Service
public class ReadingServiceImplementation implements ReadingService {
	
	@Autowired
	ReadingRepository readingRepository;
	
	@Autowired
	VehicleService vehicleService;
	
	@Autowired
	AlertService alertService;

	@Autowired
	EmailService emailService;

	// Create Alerts
	@Transactional
	public void createReading(Reading reading) {
		if (reading == null) {
			throw new BadRequestException("The Reading is Empty");
		}
		String readingVin = reading.getVin();
		Vehicle existingVehicle = vehicleService.findVehicleByVin(readingVin);
		if (existingVehicle != null) {
			checkAlerts(existingVehicle, reading);
		}
		readingRepository.save(reading);
	}

	public void checkAlerts(Vehicle vehicle, Reading reading) {
		List<Alert> alertList = new ArrayList<Alert>();
		alertList.add(alertService.checkEngineRPM(vehicle, reading));
		alertList.add(alertService.checkEngineCoolant(vehicle, reading));
		alertList.add(alertService.checkEngineLightOn(vehicle, reading));
		alertList.add(alertService.checkFuelVolume(vehicle, reading));
		alertList.add(alertService.checkTirePressure(vehicle, reading));
		insertAlert(alertList, vehicle, reading);
	}

	@Transactional
	public void insertAlert(List<Alert> alertList, Vehicle vehicle, Reading reading) {
		if (alertList == null) {
			return;
		}
		for (Alert alert : alertList) {
			if (alert != null) {
				alertService.createAlert(alert);
				emailService.sendEmail(vehicle, reading, alert);
			}
		}
	}

//	@Transactional(readOnly = true)
//	public List<Reading> getReadingByVin(String readingVin) {
//		List<Reading> existingReading = readingRepository.findOne(readingVin);
//		if (existingReading == null) {
//			throw new ResourceNotFoundException("Reading with Vin: " + readingVin + "not found");
//		}
//		return existingReading;
//	}

	@Transactional(readOnly = true)
	public List<Reading> getAllReadings() {
		List<Reading> existingReading = readingRepository.findAll();
		if (existingReading == null) {
			throw new ResourceNotFoundException("No Readings found");
		}
		return existingReading;
	}
}
