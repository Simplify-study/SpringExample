package com.jonghun.example.e08.rest;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.jonghun.example.e05.service.SecurityMember;

@Controller
public class RestController {

	@Autowired
	RestTemplate restTemplate;
	
	@RequestMapping("/rest")
	public String home(@AuthenticationPrincipal SecurityMember securityMember) {
		
		String obj = restTemplate.getForObject("http://naver.com", String.class);
		System.out.println(obj);
		return "";
	}
	
	@Bean
	public RestTemplate restTemplate() {
		
		HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
		factory.setReadTimeout(5000); // 읽기시간초과, ms 
		factory.setConnectTimeout(3000); // 연결시간초과, ms 
		
		HttpClient httpClient = HttpClientBuilder.create() 
				.setMaxConnTotal(100) // connection pool 적용 
				.setMaxConnPerRoute(5) // connection pool 적용 
				.build();

		factory.setHttpClient(httpClient); // 동기실행에 사용될 HttpClient 세팅 RestTemplate
		RestTemplate restTemplate = new RestTemplate(factory);

		return restTemplate;
	}
}
