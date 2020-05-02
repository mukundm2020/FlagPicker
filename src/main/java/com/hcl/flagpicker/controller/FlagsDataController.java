/**
 * 
 */
package com.hcl.flagpicker.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.hcl.flagpicker.service.FlagService;

import io.swagger.annotations.Api;

/**
 * @author Dinesh P FlagsDataController is main controller class for getting
 *         Flags data.
 */
@RestController
@RequestMapping("/flagsapi")
@Api(value = "Flag Picker System", description = "Operations pertaining to fetch Flag data for a Country/Continent")
public class FlagsDataController {

	@Autowired
	HttpServletRequest request;
	
	private static final Logger logger = LoggerFactory.getLogger(FlagsDataController.class);
	@Autowired(required = true)
	FlagService flagsService;

	/**
	 * @param continentName
	 * @return country and corresponding flags of the provided continent
	 */
	@RequestMapping(value="/continent/{continentName}",method = {RequestMethod.GET, RequestMethod.PUT})
	//@PutMapping("/continent/{continentName}")
	public ResponseEntity<Map<String, JsonNode>> getFlagByContinent(@PathVariable("continentName") final String continentName) throws IOException {
		logger.info("In getFlagByContinent() of Data Controller.. "+continentName);
		return flagsService.getFlagByContinent(continentName);	
	}
	
	/**
	 * @param countryName
	 * @return flags of the country name provided
	 */
	@RequestMapping(value= {"/country/{countryName}","/countries/{countryName}"}, produces = {"application/json",   "application/xml" })
	public ResponseEntity<Map<String, JsonNode>> getFlagByCountry(@PathVariable("countryName") final String countryName) throws IOException {
		logger.info("In getFlagByCountry() of Data Controller.. "+countryName);
		System.out.println(request.getHeaderNames());
		while(request.getHeaderNames().hasMoreElements()) {
			String name=request.getHeaderNames().nextElement();
			name=request.getHeaderNames().nextElement();
			System.out.println(name);
		}
		return flagsService.getFlagByCountry(countryName);	
		
	}
	 @PostMapping(path = "/hello", consumes = MediaType.APPLICATION_JSON_VALUE)
	  public String hello(@RequestBody String val) {
	    return "Hello from string"+val;
	  }

//	  @PostMapping(path = "/hello", consumes = MediaType.APPLICATION_XML_VALUE)
//	  public String hello(@RequestBody TestBean val) {
//	    return "Hello from int ";
//	  }
	  
	  @GetMapping(value = "/ex/foos",headers = { "key1=val1", "key2=val2" })//, method = HttpMethod.GET)
			public String getFoosWithHeaders() {
			    return "Get some Foos with Header";
			}
	  
	  @GetMapping(value = "/test",headers = { "key1=val1", "key2=val2" })//, method = HttpMethod.GET)
		public String test() {
		    return "Passing headers while requesting";
		}
//	  
//	  @PostMapping(value = "/test2",headers = { "Accept=application/json"})//, method = HttpMethod.GET)
//		public String test2(@RequestBody TestBean str) {
//		    return "Passing accept headers while requesting as JSON : "+str;
//		}
//	  
	  //a fallback for all GET requests
	  @GetMapping(value = "*")//, method = HttpMethod.GET)
		public String test3() {
		    return "a fallback for all GET requests ";
		}
}
 
