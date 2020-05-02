package com.hcl.flagpicker.service;

import java.io.IOException;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.hcl.flagpicker.exceptions.RecordNotFoundException;
import com.hcl.flagpicker.repository.JsonRepository;
import com.hcl.flagpicker.util.FlagUtils;

/**
 * @author Dinesh P 
 * FlagServiceImpl is implementation of FlagService
 */

@Service
public class FlagServiceImpl implements FlagService {

	private static final Logger logger = LoggerFactory.getLogger(FlagServiceImpl.class);
	
	@Value("${json.file.path}")
	private String jsonFilePath; 
	
	@Autowired(required=true)
	JsonRepository jsonRepo;
	 
	/**
	 * Input: continentName returns the flag based on provided continent name
	 */
	
	@Override
	public ResponseEntity<Map<String, JsonNode>> getFlagByContinent(String continentName) throws IOException {
		logger.debug("In getFlagByContinent()");
		if(FlagUtils.isNullOrEmpty(continentName)) {
			throw new RecordNotFoundException("Invalid data provided=>  continentName " + continentName);
		}
		logger.debug("In getFlagByContinent(), fetching flag data of continent name " + continentName);
		ResponseEntity<Map<String, JsonNode>> result=jsonRepo.getFlagByContinent(continentName, jsonFilePath);
		 return result;
	}
	
	/**
	 * Input: countryName returns the flag based on provided country name
	 */
	@Override
	public ResponseEntity<Map<String, JsonNode>> getFlagByCountry(String countryName) throws IOException {
		logger.debug("In getFlagByCountry() service layer");
		if(FlagUtils.isNullOrEmpty(countryName)) {
			throw new RecordNotFoundException("Invalid data provided=>  countryName " + countryName);
		}
		logger.debug("In getFlagByContinent(), fetching flag data of country name " + countryName);
		ResponseEntity<Map<String, JsonNode>> result=jsonRepo.getFlagByCountry(countryName, jsonFilePath);
		return result;
		 
	}

}
