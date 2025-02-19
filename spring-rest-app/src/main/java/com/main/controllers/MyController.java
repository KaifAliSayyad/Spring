package com.main.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	
	
	@GetMapping(path="/", produces = "text/html")
//	@ResponseBody				//No need to write this in Rest API
	public String abc() {
		return "<html><body><h1> Welcome to REST API application </h1><hr><h2>Thank you </h2></body></html>";
	}
	
	@GetMapping("/greet")
	public String xyz() {
		return "<h1>Have a great day! (GET) </h1>";
	}
	@PostMapping("/greet")
	public String gfd() {
		return "<h1>Have a great day! (POST) </h1>";
	}
	@PutMapping("/greet")
	public String dfssd() {
		return "<h1>Have a great day! (PUT) </h1>";
	}
	@PatchMapping("/greet")
	public String ddsfds() {
		return "<h1>Have a great day! (PATCH) </h1>";
	}
	@DeleteMapping("/greet")
	public String gfdgd() {
		return "<h1>Have a great day! (DELETE) </h1>";
	}
}
