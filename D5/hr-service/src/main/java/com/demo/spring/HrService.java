package com.demo.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.demo.spring.entity.Emp;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class HrService {

	@Autowired
	RestTemplate rt;

	@HystrixCommand(fallbackMethod = "reliable")
	public Emp processFind(int id) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", "application/json");

		HttpEntity req = new HttpEntity(headers);

		ResponseEntity<Emp> resp1 = rt.exchange("http://EMP-SERVICE/emp/find?id="+id,
				HttpMethod.GET, req,
				Emp.class);
		return resp1.getBody();
	}

	public List<Emp> processList() {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", "application/json");

		HttpEntity req = new HttpEntity(headers);

		ResponseEntity<List<Emp>> resp1 = rt.exchange("http://emp-service/emp",
				HttpMethod.GET, req,
				new ParameterizedTypeReference<List<Emp>>() {
				});
		return resp1.getBody();
	}
	
	public Emp reliable(int id) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", "application/json");

		HttpEntity req = new HttpEntity(headers);
		Emp e = new Emp();
		
		return e;
	}
	
}