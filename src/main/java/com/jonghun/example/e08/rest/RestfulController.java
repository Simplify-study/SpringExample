package com.jonghun.example.e08.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.jonghun.example.e05.service.SecurityMember;

@RestController
public class RestfulController {

	@Autowired
	RestTemplate restTemplate;
	
	@RequestMapping("/rest")
	public String home(@AuthenticationPrincipal SecurityMember securityMember) {
		
		String obj = restTemplate.getForObject("http://naver.com", String.class);
		System.out.println(obj);
		return "";
	}
	
	
}
