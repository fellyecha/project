package com.bcaf.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bcaf.project.model.UserRole;
import com.bcaf.project.repository.UserRoleRepo;

@Controller
@RequestMapping(value = "/userRole/")
public class UserRoleController {
	@Autowired
	private UserRoleRepo repo;
	
	@GetMapping(value = "index")
	public ModelAndView index() {
		ModelAndView view = new ModelAndView("userRole/index");
		List<UserRole> list = this.repo.findAll();
		view.addObject("list", list);
		return view;
	}
}
