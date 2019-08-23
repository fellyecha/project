package com.bcaf.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bcaf.project.model.DataDistribution;
import com.bcaf.project.model.StatusData;
import com.bcaf.project.repository.DataDistributionRepo;
import com.bcaf.project.repository.StatusDataRepo;

@Controller
@RequestMapping(value = "/custDataCMO/")
public class CustDataCMOController {
	@Autowired
	private DataDistributionRepo repo;
	
	@Autowired
	private StatusDataRepo statRepo;
	
	@GetMapping(value="index")
	public ModelAndView index() {
		ModelAndView view = new ModelAndView("custDataCMO/index");
		List<DataDistribution> list = this.repo.findAll();
		view.addObject("list", list);
		return view;
	}
	
	//
	
	@GetMapping(value="edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		ModelAndView view = new ModelAndView("custDataCMO/_form");
		DataDistribution item = this.repo.findById(id).orElse(null);
		view.addObject("objCustData", item);
		List<StatusData> listStatus = this.statRepo.findAll();
		view.addObject("listStatus", listStatus);
		return view;
	}
	
	@PostMapping(value = "save")
	public ModelAndView save(@ModelAttribute DataDistribution objCustData, BindingResult result) {
		ModelAndView view = new ModelAndView("custDataCMO/_form");
		if(result.hasErrors()) {
			view.addObject("objCustData", objCustData);
		}
		else {
			this.repo.save(objCustData);
			view.addObject("objCustData", new DataDistribution());
		}
		
		return view;
		
	}

	@GetMapping(value = "list")
	public ModelAndView list() {
		ModelAndView view = new ModelAndView("custDataCMO/_list");
		List<DataDistribution> list = this.repo.findAll();
		view.addObject("list", list);
		return view;
	}
}
