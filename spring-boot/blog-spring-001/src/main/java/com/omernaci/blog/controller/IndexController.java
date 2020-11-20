package com.omernaci.blog.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.omernaci.blog.model.Post;

@Controller
public class IndexController {
	
	private static List<Post> postList = new ArrayList<>();
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@PostMapping("/posts")
	public ModelAndView savePost(@ModelAttribute Post post) {
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("posts");
		
		postList.add(post);
		
		modelAndView.addObject("postList", postList);
		
		return modelAndView;
	}

}
