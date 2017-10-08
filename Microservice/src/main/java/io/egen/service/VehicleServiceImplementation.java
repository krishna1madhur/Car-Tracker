package io.egen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.entity.Vehicle;
import io.egen.repository.VehicleRespository;
import io.egen.exception.BadRequestException;
import io.egen.exception.ResourceNotFoundException;

@Service
public class VehicleServiceImplementation implements VehicleService {
	
	@Autowired
	VehicleRespository vehicleRepository;

	@Transactional
	public void createVehicle(List<Vehicle> vehicleList) {
		if (vehicleList.isEmpty() || vehicleList == null) {
			throw new BadRequestException("Vehicle list is Empty");
		}
		
		for (Vehicle vehicle : vehicleList) {
			vehicleRepository.save(vehicle);
		}
	}

	@Transactional(readOnly = true)
	public List<Vehicle> findAllVehicles() {
		List<Vehicle> vehicleList = vehicleRepository.findAll();
		if (vehicleList == null) {
			throw new ResourceNotFoundException("There are no vehicles in the database");
		}
		return vehicleList;
	}

	@Transactional(readOnly = true)
	public Vehicle findVehicleByVin(String vehicleVin) {
		Vehicle existingVehicle = vehicleRepository.findOne(vehicleVin);
		if (existingVehicle == null) {
			throw new ResourceNotFoundException("Vehicle with Vin: " + vehicleVin + " doesn't exist");
		}
		return existingVehicle;
	}

	@Transactional
	public void updateVehicle(String vehicleVin, Vehicle vehicle) {
		Vehicle existingVehicle = vehicleRepository.findOne(vehicleVin);
		if (existingVehicle == null) {
			throw new ResourceNotFoundException("Vehicle with " + vehicleVin + " doesn't exist");
		}
	}

}
