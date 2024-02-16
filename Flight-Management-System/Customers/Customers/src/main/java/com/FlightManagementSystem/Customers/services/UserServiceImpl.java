package com.FlightManagementSystem.Customers.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.FlightManagementSystem.Customers.exceptions.RecordNotFoundException;
import com.FlightManagementSystem.Customers.exceptions.RecordsAlreadyFoundExceptions;
import com.FlightManagementSystem.Customers.exceptions.RecordsNotFoundException;
import com.FlightManagementSystem.Customers.model.Users;
import com.FlightManagementSystem.Customers.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userrepo;
	
	@Override
	public ResponseEntity<Users> createUsers(Users user) {
		Optional<Users> findUserById = userrepo.findById(user.getUserId());
		try {
			if(!findUserById.isPresent()) {
				userrepo.save(user);
				return new ResponseEntity<Users>(user,HttpStatus.OK);
			}
		else
			throw new RecordsAlreadyFoundExceptions(
			 "Users with Id : " + user.getUserId()	+ " already exists !!"	);
		}
		catch(RecordsAlreadyFoundExceptions e) {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@Override
	public List<Users> getAllUsers() {
		return userrepo.findAll();
	}

	@Override
	public Users updateUsers(Users users) {
	Optional<Users> findUserById = userrepo.findById(users.getUserId());
	if(findUserById.isPresent()) {
		userrepo.save(users);
	}
	else
		throw new RecordsNotFoundException( 
				"Users with Id :" + users.getUserId() + " not exists !!");
		return users;
	}
	
	@Override
	public String deleteUsers(Long userId) {
		Optional<Users> findBookingById = userrepo.findById(userId);
		if(findBookingById.isPresent()) {
			return "User Deleted !!";
			}
		else

			throw new RecordNotFoundException("User not found for the entered UserID");
	
	}

	@Override
	public ResponseEntity<Users> findByUserId(Long userId) {
		Optional<Users> findById = userrepo.findById(userId);
		try {
			if(findById.isPresent()) {
			Users findUsers = findById.get()	;
			return new ResponseEntity<Users>(findUsers, HttpStatus.OK);
			}
			else
				throw new RecordNotFoundException("No records found with ID" + userId);
		}
		catch (RecordNotFoundException e) 
		{
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
}
}