package com.ticket.booking.config;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ticket.booking.entity.UserDtls;

public class CustomUserDetails implements UserDetails{
	
	private UserDtls dtls;

	
	
	

	public CustomUserDetails(UserDtls dtls) {
		super();
		this.dtls = dtls;
	}
	
	public CustomUserDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		SimpleGrantedAuthority authority=new SimpleGrantedAuthority(dtls.getRole());
		return Arrays.asList(authority);
	}

	@Override
	public String getPassword() {
		
		return dtls.getPassword();
	}

	@Override
	public String getUsername() {
		
		return dtls.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	

}
