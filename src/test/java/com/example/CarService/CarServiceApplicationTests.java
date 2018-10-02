package com.example.CarService;

import com.example.CarService.Repository.WorkerRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarServiceApplicationTests {

	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
	private static final RestTemplate restTemplate = new RestTemplate();

	@Autowired
	private WorkerRepositoryImpl workerRepository;

	@BeforeClass
	public static void setUpBefore(){
		//raz przed wszystkimi testami
	}

	@AfterClass
	public static void afterTest(){
		// po wykonaniu testow
	}

	@Before
	public void setUp()throws Exception{
		// metoda wykonana przed każdym testem
	}

	@After
	public void after() throws Exception{
		// metoda wykonana po kazdym tescie
	}
//	@Test
//	public void testCreateIssue() throws IOException {
//
//		Map<String,Object> requestBody = new HashMap<>();
//		requestBody.put("title","Zepsuty wahacz");
//		requestBody.put("carModel","Audi");
//		requestBody.put("registerNumber","FZA123");
//		requestBody.put("clientName","Adam Testowy");
//		requestBody.put("issueDescription","Nie dziala samochod. Ciagle cos puka");
//
//		HttpHeaders requestHeaders = new HttpHeaders();
//		requestHeaders.setContentType(MediaType.APPLICATION_JSON);
//
//		HttpEntity<String> httpEntity = new HttpEntity<>(OBJECT_MAPPER.writeValueAsString(requestBody),requestHeaders);
//
//		Map<String,Object> apiResponse = restTemplate.postForObject(
//				"http://localhost:8082/api/addIssue",httpEntity,Map.class,
//				Collections.emptyMap());
//
//		assertNotNull(apiResponse);
//	}

}
