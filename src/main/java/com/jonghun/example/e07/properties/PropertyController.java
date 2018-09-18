package com.jonghun.example.e07.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jonghun.example.e05.service.SecurityMember;

@RestController
public class PropertyController {

	@Value("${iot.home.path}")
    private String rootPath;
	
	@RequestMapping("/property")
	public String home(@AuthenticationPrincipal SecurityMember securityMember) {
		
		System.out.println(rootPath);
		
		return rootPath;
	}
}
