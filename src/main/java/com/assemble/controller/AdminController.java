package com.assemble.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/*")
public class AdminController {
	@GetMapping("/admin")
	public void admin() {
		
	}
	@GetMapping("/member")
	public void member() {
		
	}
}
