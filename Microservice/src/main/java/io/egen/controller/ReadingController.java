package io.egen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.entity.Reading;
import io.egen.service.ReadingService;

@CrossOrigin(origins = "http://mocker.egen.io", maxAge = 3600)
@RestController
@RequestMapping(value = "/readings")
public class ReadingController {

	@Autowired
	ReadingService readingService;
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void createReading(@RequestBody Reading reading) {
		readingService.createReading(reading);
	}

//	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
//	public List<Reading> findReadingByVin(@PathVariable("id") String readingVin) {
//		return readingService.getReadingByVin(readingVin);
//	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Reading> getAllREadings() {
		return readingService.getAllReadings();
	}
}
