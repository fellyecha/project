package com.bcaf.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bcaf.project.model.DataDistribution;
import com.bcaf.project.repository.DataDistributionRepo;

@Controller
@RequestMapping(value = "/dataDistribution/")
public class DataDistributionController {
	
	@Autowired
	private DataDistributionRepo repo;
	
	@GetMapping(value="index")
	public ModelAndView index() {
		ModelAndView view = new ModelAndView("dataDistribution/index");
		List<DataDistribution> list = this.repo.findAll();
		view.addObject("list", list);
		return view;
	}
}
