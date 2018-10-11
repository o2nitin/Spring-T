package com.demo.spring;

import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.demo.spring.entity.Emp;

public class GetClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String userDetails ="pavan:welcome";
		String encdCred = new String(Base64.encodeBase64(userDetails.getBytes()));
		RestTemplate rt = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", "application/json");
		headers.set("Authorization", "Basic "+encdCred);
		HttpEntity req=new HttpEntity(headers);
		ResponseEntity<String> resp1=rt.exchange("http://localhost:8081/emp", HttpMethod.GET, req, String.class);

		System.out.println(resp1.getBody());
//		ResponseEntity<List<Emp>> resp1= rt.exchange("http://localhost:8081/emp", HttpMethod.GET, req, new ParameterizedTypeReference< List<Emp>>() {
//		});
//
//		resp1.getBody().stream().forEach(e->System.out.println(e.getName() +" "+e.getCity()));
		

	}

}
