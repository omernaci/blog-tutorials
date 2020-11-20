package com.omernaci.blog.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogController {
	
	@Value("${blog.url}")
	private String blogUrl;
	
	@GetMapping
	public String index() {
		return "" + blogUrl;
	}

}
