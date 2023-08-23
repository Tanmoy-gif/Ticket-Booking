package com.ticket.booking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticket.booking.entity.UserDtls;
import com.ticket.booking.repository.UserRepo;

@Service
public class TrainService {
	
	@Autowired
	private UserRepo repo;
	
	
	public UserDtls saveUser(UserDtls user) {
		UserDtls u=repo.save(user);
		return u;
	}
	
	

}
