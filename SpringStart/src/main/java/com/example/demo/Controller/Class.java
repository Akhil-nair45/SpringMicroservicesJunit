package com.example.demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Class {

	@GetMapping("/call")
	public String hello()
	{
		return "Hello There";
	}
}
