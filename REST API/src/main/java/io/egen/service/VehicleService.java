package io.egen.service;
import java.util.List;

import io.egen.entity.Vehicle;

public interface VehicleService {
	List<Vehicle> findAllVehicles();
	
	Vehicle findVehicleByVin(String vehicleVin);
	
	void createVehicle(List<Vehicle> vehicleList);
	
	Vehicle updateVehicle(String vehicleVin, Vehicle vehicle);
	
}
