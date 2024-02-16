package com.FlightManagementSystem.Customers.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FlightManagementSystem.Customers.model.Users;
import com.FlightManagementSystem.Customers.services.UserService;
@RestController
@RequestMapping("/customer")
public class UserController {
	@Autowired
	UserService userservice;
	
	@PostMapping("/users")
	public ResponseEntity<String> addUsers(@RequestBody  Users user) {
		userservice.createUsers(user);
     return new ResponseEntity<>("registered successfully", HttpStatus.OK);
	}
	@GetMapping("display")
	 public ResponseEntity<List<Users>> getAllUsers(){
	     List<Users> users = userservice.getAllUsers();
	     return new ResponseEntity<>(users,HttpStatus.OK);
	    }
	@PutMapping("updateUser")
	public ResponseEntity<String> updateUsers(@RequestBody Users users) {
		userservice.updateUsers(users);
		return new ResponseEntity<>("updated successfully", HttpStatus.OK);
		
	}
	@GetMapping("search/{id}")
	public ResponseEntity<Users> searchUserById(@PathVariable("id") Long userId){
		return userservice.findByUserId(userId);
		
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteBookingId(@PathVariable("id") Long userId) {
		userservice.deleteUsers(userId);
		return new ResponseEntity<>("deleted successfully", HttpStatus.OK);
	}

}
