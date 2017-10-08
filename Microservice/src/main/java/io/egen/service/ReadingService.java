package io.egen.service;

import java.util.List;

import io.egen.entity.Reading;

public interface ReadingService {
	
	void createReading(Reading reading);
	
	//List<Reading> getReadingByVin(String readingVin);
	
	List<Reading> getAllReadings();

}
