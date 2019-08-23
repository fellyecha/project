package com.bcaf.project.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bcaf.project.model.User;
import com.bcaf.project.repository.UserRepo;

@RestController
@RequestMapping("api/public")
@CrossOrigin
public class PublicRestApiController {
	private UserRepo userRepo;
	
	public PublicRestApiController(UserRepo userRepo) {
		this.userRepo = userRepo;
	}
	
	@GetMapping("test")
	public String test1() {
		return "API Test";
	}
	
	@GetMapping("management/reports")
	public String reports() {
		return "Some report data";
	}
	
	@GetMapping("admin/users")
	public List<User> users() {
		return this.userRepo.findAll();
	}
}
