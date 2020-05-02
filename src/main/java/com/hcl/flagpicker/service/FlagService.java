package com.hcl.flagpicker.service;

import java.io.IOException;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * @author Dinesh P
 *  SalesService is a service interface of sales 
 */
public interface FlagService  {
	public ResponseEntity<Map<String, JsonNode>> getFlagByContinent(@PathVariable("continentName") final String continentName) throws IOException ;
	public ResponseEntity<Map<String, JsonNode>> getFlagByCountry(@PathVariable("countryName") final String countryName) throws IOException ;
	 
}
