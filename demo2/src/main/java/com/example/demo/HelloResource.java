package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/rest/hello")
public class HelloResource {
	
	@GetMapping
	@ApiOperation(value="헬로월드", notes="헬로월드를 조회한다")
	public String hello() {
		return "Hello World";
	}
	
	@PostMapping("/post")
	public String helloPost(@RequestBody final String hello) {
		return hello;
	}
	
	@PutMapping("/put")
	public String HelloPut(@RequestBody final String hello) {
		return hello;
	}
}
