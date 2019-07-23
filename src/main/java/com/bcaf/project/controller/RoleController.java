package com.bcaf.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bcaf.project.model.Role;
import com.bcaf.project.repository.RoleRepo;

@Controller
@RequestMapping(value = "/role/")
public class RoleController {
	@Autowired
	private RoleRepo repo;
	
	@GetMapping(value = "index")
	public ModelAndView index() {
		ModelAndView view = new ModelAndView("role/index");
		List<Role> list = this.repo.findAll();
		view.addObject("list", list);
		return view;
	}
}
