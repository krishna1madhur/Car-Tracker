package io.egen.repository;

import java.util.List;
import io.egen.entity.Reading;

public interface ReadingRepository {

	List<Reading> getAllReadings();

	void createReading(Reading reading);

	List<Reading> getReadingByVin(String vehicleVin);

}
