package com.jonghun.example.e03.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jonghun.example.e02.pathvariable.Home;
import com.jonghun.example.e04.UserMapper;
import com.jonghun.example.e05.service.Member;

@RestController
public class PathVariableController2 {

	@Autowired
	HomeMapper homeMapper;
	
	@Autowired
	UserMapper userMapper;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@RequestMapping("/{name}")
	public Home home(@PathVariable String name) {
		Home home = homeMapper.readHome(name);
		return home;
	}

	@RequestMapping("/readUser")
	public Member readUser() {
		
//		String encodePass = passwordEncoder.encode("abcd");
//		System.out.println(encodePass);
		
		Member member = userMapper.readUser("ABC");
		return member;
	}
}
