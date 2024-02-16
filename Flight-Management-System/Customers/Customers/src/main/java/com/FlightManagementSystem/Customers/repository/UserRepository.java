package com.FlightManagementSystem.Customers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.FlightManagementSystem.Customers.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users,Long> {

}
