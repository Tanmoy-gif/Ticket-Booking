package com.ticket.booking.controller;

import java.security.Principal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ticket.booking.entity.UserDtls;
import com.ticket.booking.repository.UserRepo;
import com.ticket.booking.service.TrainService;



@Controller
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	private UserRepo userRepo;

	@Autowired
	private TrainService userService;
	
	@ModelAttribute
	public void addCommonData(Principal p,Model m) {
		String email=p.getName();
		System.out.println(email);
		UserDtls user=userRepo.findByEmail(email);
		m.addAttribute("user",user);
	}
	
	@GetMapping("/home") 
	public String home(Principal p) { 
		
		System.out.println("User name is"+p);
		return "user/home"; 
	}

}
