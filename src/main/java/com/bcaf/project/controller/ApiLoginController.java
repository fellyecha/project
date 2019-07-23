package com.bcaf.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bcaf.project.repository.UserRepo;

@RestController
@RequestMapping(value = "api/login")
public class ApiLoginController {
	
	@Autowired
	UserRepo repo;
	

}
