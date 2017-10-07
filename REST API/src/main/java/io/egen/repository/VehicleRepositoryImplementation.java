package io.egen.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import io.egen.entity.Vehicle;

@Repository
public class VehicleRepositoryImplementation implements VehicleRespository {
	
	@javax.persistence.PersistenceContext
    private EntityManager entityManager;
	
	public void createVehicle(Vehicle vehicle) {
		entityManager.persist(vehicle);
	}

	public Vehicle getVehicleByVin(String vin) {
		return entityManager.find(Vehicle.class, vin);
	}

	public List<Vehicle> getVehicles() {
		TypedQuery<Vehicle> query = entityManager.createNamedQuery("Vehicle.getAllVehcles",Vehicle.class);
		return query.getResultList();
	}

	public Vehicle update(Vehicle vehicle) {
		return entityManager.merge(vehicle);
	}

}
