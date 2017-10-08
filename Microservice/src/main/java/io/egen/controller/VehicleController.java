package io.egen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import io.egen.entity.Vehicle;
import io.egen.service.VehicleService;

@CrossOrigin(origins = "http://mocker.egen.io", maxAge = 3600)
@RestController
@RequestMapping(value = "/vehicles")
public class VehicleController {

	@Autowired
	VehicleService vehicleService;

	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void create(@RequestBody List<Vehicle> vehicleList) {
		vehicleService.createVehicle(vehicleList);
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Vehicle> findAllVehicles() {
		return vehicleService.findAllVehicles();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Vehicle findVehicleByVin(@PathVariable("id") String vehicleVin) {
		return vehicleService.findVehicleByVin(vehicleVin);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void update(@PathVariable("id") String vehicleVin, @RequestBody Vehicle vehicle) {
		vehicleService.updateVehicle(vehicleVin, vehicle);
	}

}
