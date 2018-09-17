package com.jonghun.example.e01.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jonghun.example.e05.service.SecurityMember;

@RestController
public class HomeController {

	@RequestMapping("/")
	public String home(@AuthenticationPrincipal SecurityMember securityMember) {
		
		System.out.println(securityMember);
		System.out.println(securityMember.getUsername());
		System.out.println(securityMember.getIp());
		
		return "hello";
	}
}
