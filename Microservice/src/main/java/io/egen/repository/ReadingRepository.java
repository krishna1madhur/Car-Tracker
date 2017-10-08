package io.egen.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import io.egen.entity.Reading;

public interface ReadingRepository extends Repository<Reading, Long>{

	public List<Reading> findAll();
	
	public Reading save(Reading reading);

	//public List<Reading> findOne(String vin);

}
