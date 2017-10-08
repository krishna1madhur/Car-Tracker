package io.egen.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.egen.entity.Alert;
import io.egen.entity.Reading;
import io.egen.entity.Vehicle;
import io.egen.repository.AlertRepository;
import io.egen.entity.Alert.AlertType;
import io.egen.entity.Alert.Priority;

@Service
public class AlertServiceImplementation implements AlertService {
	
	@Autowired
	AlertRepository alertRepository;

	public Alert checkEngineRPM(Vehicle vehicle, Reading reading) {
		Alert alert = null;
		if (reading.getEngineRpm() > vehicle.getRedlineRpm()) {
			alert = new Alert();
			alert.setReading(reading);
			alert.setPriorityValue(Priority.HIGH);
			alert.setAlertType(AlertType.ENGINERPM);
			alert.setVehicle(vehicle);
		}
		return alert;
	}

	public Alert checkFuelVolume(Vehicle vehicle, Reading reading) {
		Alert alert = null;
		double minFuelVolumeValue = (0.1) * vehicle.getMaxFuelVolume();
		if (reading.getFuelVolume() < minFuelVolumeValue) {
			alert = new Alert();
			alert.setReading(reading);
			alert.setPriorityValue(Priority.MEDIUM);
			alert.setAlertType(AlertType.FUELVOLUME);
			alert.setVehicle(vehicle);
		}
		return alert;
	}

	public Alert checkTirePressure(Vehicle vehicle, Reading reading) {
		Alert alert = null;
		List<Double> tires = new ArrayList<Double>();
		tires.add(reading.getTires().getFrontLeft());
		tires.add(reading.getTires().getFrontRight());
		tires.add(reading.getTires().getRearLeft());
		tires.add(reading.getTires().getRearRight());

		for (Double tire : tires) {
			if (tire < 32 || tire > 36) {
				alert = new Alert();
				alert.setReading(reading);
				alert.setPriorityValue(Priority.LOW);
				alert.setAlertType(AlertType.TIREPRESSURE);
				alert.setVehicle(vehicle);
				break;
			}
		}
		return alert;
	}

	public Alert checkEngineCoolant(Vehicle vehicle, Reading reading) {
		Alert alert = null;
		if (reading.isEngineCoolantLow()) {
			alert = new Alert();
			alert.setReading(reading);
			alert.setPriorityValue(Priority.LOW);
			alert.setAlertType(AlertType.ENGINECOOLANTLOW);
			alert.setVehicle(vehicle);
		}
		return alert;
	}

	public Alert checkEngineLightOn(Vehicle vehicle, Reading reading) {
		Alert alert = null;
		if (reading.isCheckEngineLightOn()) {
			alert = new Alert();
			alert.setReading(reading);
			alert.setPriorityValue(Priority.LOW);
			alert.setAlertType(AlertType.ENGINELIGHTSON);
			alert.setVehicle(vehicle);
		}
		return alert;
	}

	public void createAlert(Alert alert) {
		alertRepository.createAlert(alert);
	}
}
