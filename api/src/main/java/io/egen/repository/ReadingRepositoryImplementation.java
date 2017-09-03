package io.egen.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import io.egen.entity.Reading;

@Repository
public class ReadingRepositoryImplementation implements ReadingRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public void createReading(Reading reading) {
		entityManager.persist(reading);
	}

	public List<Reading> getAllReadings() {
		TypedQuery<Reading> query = entityManager.createNamedQuery("Reading.findAll", Reading.class);
		return query.getResultList();
	}

	public List<Reading> getReadingByVin(String vehicleVin) {
		TypedQuery<Reading> query = entityManager.createNamedQuery("Reading.findReadingByVin", Reading.class);
		query.setParameter("paramVin", vehicleVin);
		return query.getResultList();
	}

}
