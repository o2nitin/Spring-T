package com.demo.spring;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.demo.spring.entity.Emp;

public class PostClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestTemplate rt = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", "text/plain");
		headers.set("Content-Type", "application/json");
		Emp e = new Emp(205,"Ankita","Hyderabad", 45000);
		
		HttpEntity req=new HttpEntity(e,headers);
//		ResponseEntity<String> resp1=rt.exchange("http://localhost:8081/emp", HttpMethod.GET, req, String.class);
//
//		System.out.println(resp1.getBody());
		ResponseEntity<String> resp1= rt.exchange("http://localhost:8081/emp/save", HttpMethod.POST, req, String.class);

		//resp1.getBody().stream().forEach(e->System.out.println(e.getName() +" "+e.getCity()));
		System.out.println(resp1.getBody());

	}

}
