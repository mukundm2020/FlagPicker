//package com.hcl.flagpicker.flagpicker;
//
//import java.net.URI;
//
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
//import org.springframework.boot.web.server.LocalServerPort;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.web.client.RestTemplate;
//
//import com.hcl.flagpicker.controller.FlagsDataController;
//import com.hcl.flagpicker.main.FlagPickerApplication;
// 
//
///**
// * @author Dinesh P
// *  FlagPickerApplicationTests contains Junit test cases for Flag Picker API 
// */
//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
//@ContextConfiguration(classes = FlagPickerApplication.class)
//public class FlagPickerApplicationTests {
//
//	@LocalServerPort
//	int randomPort;
//
//	@Mock
//	private FlagsDataController sm;
//
//	 
//
//	@Test
//	public void testFlagByCountrySuccess() throws Exception {
//		RestTemplate test = new RestTemplate();
//		String countryName="India";
//		final String baseUrl = "http://localhost:" + randomPort + "/flagsapi/country/"+countryName;
//		URI uri = new URI(baseUrl);
//		ResponseEntity<String> result = test.getForEntity(uri, String.class);
//		Assert.assertEquals(200, result.getStatusCodeValue());
//	//	Assert.assertEquals(true, result.getBody().contains("IN"));
//
//	}
//
//	@Test
//	public void testFlagByContinentSuccess() throws Exception {
//		RestTemplate test = new RestTemplate();
//		String continentName="Asia";
//		final String baseUrl = "http://localhost:" + randomPort + "/flagsapi/continent/"+continentName;
//		URI uri = new URI(baseUrl);
//		ResponseEntity<String> result = test.getForEntity(uri, String.class);
//		Assert.assertEquals(200, result.getStatusCodeValue());
//		Assert.assertEquals(true, result.getBody().contains("India"));
//	} 
//	
//	@Test
//	public void testFlagByContinentFail() throws Exception {
//		RestTemplate test = new RestTemplate();
//		String continentName="Asia";
//		final String baseUrl = "http://localhost:" + randomPort + "/flagsapi/continent/"+continentName;
//		URI uri = new URI(baseUrl);
//		ResponseEntity<String> result = test.getForEntity(uri, String.class);
//		Assert.assertEquals(400, result.getStatusCodeValue());
//		//Assert.assertEquals(true, result.getBody().contains("America"));
//
//	}
//	
//}
