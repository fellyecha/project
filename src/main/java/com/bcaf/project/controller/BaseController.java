package com.bcaf.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;

import com.bcaf.project.model.User;
import com.bcaf.project.repository.UserRepo;

@Controller
public class BaseController {
	
	@Autowired
	private UserRepo repo;
	
	public User getUser() {
		 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		 UserDetails userDetail = (UserDetails) auth.getPrincipal();
		 
		 User user = repo.findByUsername(userDetail.getUsername());
		 return user;
	}
}
