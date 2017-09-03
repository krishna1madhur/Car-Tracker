package io.egen.service;

import io.egen.entity.Alert;
import io.egen.entity.Reading;
import io.egen.entity.Vehicle;

public interface EmailService {
	
	void sendEmail(Vehicle vehicle, Reading reading, Alert alert);
	
}
