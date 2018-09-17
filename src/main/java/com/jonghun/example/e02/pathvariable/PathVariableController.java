package com.jonghun.example.e02.pathvariable;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PathVariableController {

	@RequestMapping("/path/{name}")
	public String path(@PathVariable String name) {
		return "hello, " + name;
	}
	
	@RequestMapping("/path/{name}/{message}")
	public Home path02(@PathVariable String name, @PathVariable String message) {
		
		Home home = new Home();
		home.setName(name);
		home.setMessage(message);
		
		return home; // 화면에 json 형태로 보임
	}
}
