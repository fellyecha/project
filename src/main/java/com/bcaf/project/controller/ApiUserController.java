package com.bcaf.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bcaf.project.model.User;
import com.bcaf.project.repository.UserRepo;

@RestController
@RequestMapping(value = "/api/user")
public class ApiUserController {
	@Autowired
	private UserRepo repo;
	
	@GetMapping(value="/")
	public List<User> list(){
		return this.repo.findAll();
		//findAll itu method yg ada di JpaRepository
		//makanya bisa dipake disini
	}
	
	@GetMapping(value="/{id}")
	public User detail(@PathVariable("id") Long id) {
		return this.repo.findById(id).orElse(null);
	}
	
	@PostMapping(value="/")
	public ResponseEntity<User> save(@RequestBody User item) {
		ResponseEntity<User> result = null;
		try {
			this.repo.save(item);
			result = new ResponseEntity<User>(HttpStatus.OK);
		} catch (Exception e) {
			result = new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
}
