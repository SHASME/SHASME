package com.FlightManagementSystem.Customers.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.FlightManagementSystem.Customers.model.Users;

@Service
public interface UserService {

	public ResponseEntity<Users> createUsers(Users user);
	
	public List<Users> getAllUsers();
	
	public Users updateUsers(Users users);
	
	public String deleteUsers(Long userId);

    public ResponseEntity<Users> findByUserId(Long userId);
}
