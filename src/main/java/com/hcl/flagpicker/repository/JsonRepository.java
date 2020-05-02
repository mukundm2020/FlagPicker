/**
 * 
 */
package com.hcl.flagpicker.repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.flagpicker.exceptions.RecordNotFoundException;

/**
 * @author Dinesh P
 *
 */
@Repository
public class JsonRepository {
	
	private static final Logger logger = LoggerFactory.getLogger(JsonRepository.class);
	
	
	public ResponseEntity<Map<String, JsonNode>> getFlagByContinent(String continentName,String jsonFilePath) throws IOException {
		 
		logger.debug("In getFlagByContinent(), fetching flag data of continent name " + continentName);
		HashMap<String, JsonNode>result=new HashMap<String,JsonNode>();
		ObjectMapper objectMapper = new ObjectMapper();
		byte[] jsonData = Files.readAllBytes(Paths.get(jsonFilePath));
		JsonNode allData = objectMapper.readTree(jsonData);
		for(int i=0;i<allData.size();i++) {
			JsonNode continentNode = allData.path(i);  
			String contName=continentNode.findValue("continent").toString();
				if(continentName.equalsIgnoreCase((contName.substring(1, contName.length()-1)))) {
					JsonNode country = continentNode.path("countries");  
					for(int k=0;k<country.size();k++) {
						JsonNode countryFlag = country.path(k); 
						result.put(countryFlag.findPath("name").toString().substring(1, countryFlag.findPath("name").toString().length()-1), countryFlag.findPath("flag"));
					}
		}
		}
		if(result.isEmpty())
			throw new RecordNotFoundException("No Data found with the given continent name:" + continentName);
		else  
			return ResponseEntity.ok(result);
	}
	
	public ResponseEntity<Map<String, JsonNode>> getFlagByCountry(String countryName,String jsonFilePath) throws IOException {
		 
		logger.debug("In getFlagByCountry(), fetching flag data of country name " + countryName);
		HashMap<String, JsonNode>result=new HashMap<String,JsonNode>();
		ObjectMapper objectMapper = new ObjectMapper();
		byte[] jsonData = Files.readAllBytes(Paths.get(jsonFilePath));
		JsonNode allData = objectMapper.readTree(jsonData);
		for(int i=0;i<allData.size();i++) {
			JsonNode continentNode = allData.path(i);  
					JsonNode country = continentNode.path("countries");  
					for(int k=0;k<country.size();k++) {
						JsonNode countryFlag = country.path(k); 
						String contyName=countryFlag.findValue("name").toString();
						if(countryName.equalsIgnoreCase(contyName.substring(1, contyName.length()-1))) {
							result.put(countryFlag.findPath("name").toString().substring(1, countryFlag.findPath("name").toString().length()-1), countryFlag.findPath("flag"));
						}
					}
		}
		if(result.isEmpty())
			throw new RecordNotFoundException("No Data found with the given country name:" + countryName);
		else  
			return ResponseEntity.ok(result);
	}
	

}
