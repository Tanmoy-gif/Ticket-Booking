package com.ticket.booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ticket.booking.entity.UserDtls;
import com.ticket.booking.service.TrainService;

@Controller
public class HomeController {
	
	@Autowired
	private TrainService service;
	
	@Autowired
	private BCryptPasswordEncoder bp;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/signup")
	public String signUp() {
		return "signup";
	}
	
	@PostMapping("/saveUser")
	public String SaveUser(@ModelAttribute UserDtls user,RedirectAttributes attributes) {
		System.out.println(user);
		user.setRole("ROLE_USER");
		user.setPassword(bp.encode(user.getPassword()));
		if(user!=null) {
			service.saveUser(user);
			attributes.addAttribute("msg", "User Added Successfully");
		}
		else {
			attributes.addAttribute("msg", "Something went wrong on Server");
		}
		
		return "redirect:/signup";
	}

}
