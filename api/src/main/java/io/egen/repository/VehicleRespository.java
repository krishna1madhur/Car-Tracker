package io.egen.repository;

import java.util.List;

import io.egen.entity.Vehicle;

public interface VehicleRespository {

	void createVehicle(Vehicle vehicle);

	Vehicle getVehicleByVin(String vin);

	List<Vehicle> getVehicles();

	Vehicle update(Vehicle vehicle);

}
