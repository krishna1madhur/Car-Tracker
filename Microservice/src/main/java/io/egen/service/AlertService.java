package io.egen.service;

import io.egen.entity.Alert;
import io.egen.entity.Reading;
import io.egen.entity.Vehicle;

public interface AlertService {

	Alert checkEngineRPM(Vehicle vehicle, Reading reading);

	Alert checkFuelVolume(Vehicle vehicle, Reading reading);

	Alert checkTirePressure(Vehicle vehicle, Reading reading);

	Alert checkEngineCoolant(Vehicle vehicle, Reading reading);

	Alert checkEngineLightOn(Vehicle vehicle, Reading reading);
	
	void createAlert(Alert alert);

}
