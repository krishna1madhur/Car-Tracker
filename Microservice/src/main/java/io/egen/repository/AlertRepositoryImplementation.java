package io.egen.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import io.egen.entity.Alert;

@Repository
public class AlertRepositoryImplementation implements AlertRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public void createAlert(Alert alert) {
		entityManager.persist(alert);
	}

}
