package com.bcaf.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bcaf.project.model.StatusData;
import com.bcaf.project.repository.StatusDataRepo;

@Controller
@RequestMapping(value="/statusData/")
public class StatusDataController {
	
	@Autowired
	private StatusDataRepo repo;
	
	@GetMapping(value = "index")
	public ModelAndView index() {
		ModelAndView view = new ModelAndView("statusData/index");
		List<StatusData> list = this.repo.findAll();
		view.addObject("list", list);
		return view;
	}
}
