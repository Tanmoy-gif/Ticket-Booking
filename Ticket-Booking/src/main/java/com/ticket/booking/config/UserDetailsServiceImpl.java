package com.ticket.booking.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.ticket.booking.entity.UserDtls;
import com.ticket.booking.repository.UserRepo;

@Component
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UserRepo repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
		UserDtls user=repo.findByEmail(username);
		System.out.println(user);
		if(user==null) {
			throw new UsernameNotFoundException("No User");
		}
		else {
			return new CustomUserDetails(user);
		}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
