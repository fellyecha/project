package com.bcaf.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bcaf.project.model.User;
import com.bcaf.project.repository.UserRepo;

@Controller
@RequestMapping(value="/user/")
public class UserController {
	
	@Autowired
	private UserRepo repo;
	
	@GetMapping(value = "index")
	public ModelAndView index() {
		ModelAndView view = new ModelAndView("user/index");
		List<User> list = this.repo.findAll();
		view.addObject("list", list);
		return view;
	}

}
