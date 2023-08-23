package com.ticket.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ticket.booking.entity.UserDtls;

@Repository
public interface UserRepo extends JpaRepository<UserDtls, Integer>{
	
	public UserDtls findByEmail(String email);

}
