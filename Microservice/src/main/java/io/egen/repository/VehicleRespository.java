package io.egen.repository;

import java.util.List;
import org.springframework.data.repository.Repository;

import io.egen.entity.Vehicle;

public interface VehicleRespository extends Repository<Vehicle, String>{
	
	//Insert a vehicle into the DB - Update the vehicle record in DB
	public void save(Vehicle vehicle);
	
	//Retrieve all the vehicles from the DB
	public List<Vehicle> findAll();
	
	//Retrieve vehicle by using VIN from the DB
	public Vehicle findOne(String vin);
	
}
