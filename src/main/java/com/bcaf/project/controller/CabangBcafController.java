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

import com.bcaf.project.model.CabangBcaf;
import com.bcaf.project.model.CabangDs;
import com.bcaf.project.repository.CabangBcafRepo;
import com.bcaf.project.repository.CabangDsRepo;

@Controller
@RequestMapping(value="/cabangBcaf/")
public class CabangBcafController {
	
	@Autowired
	private CabangBcafRepo repo;
	
	@Autowired
	private CabangDsRepo dsRepo;
	
	@GetMapping(value = "index")
	public ModelAndView index() {
		ModelAndView view = new ModelAndView("cabangBcaf/index");
		List<CabangBcaf> list = this.repo.findAll();
		view.addObject("list", list);
		return view;
	}
	
	@GetMapping(value = "create")
	public ModelAndView create() {
		ModelAndView view = new ModelAndView("cabangBcaf/_form");	
		view.addObject("objCabangBcaf", new CabangBcaf());
		List<CabangDs> listDs = this.dsRepo.findAll();
		view.addObject("listDs", listDs);
		return view;
	}
	
	@PostMapping(value = "save")
	public ModelAndView save(@ModelAttribute CabangBcaf objCabangBcaf, BindingResult result) {
		ModelAndView view = new ModelAndView("cabangBcaf/_form");
		if(result.hasErrors()) {
			view.addObject("objCabangBcaf", objCabangBcaf);
		}
		else {
			this.repo.save(objCabangBcaf);
			view.addObject("objCabangBcaf", new CabangBcaf());
		}
		
		return view;
		
	}
	
	@GetMapping(value="edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		ModelAndView view = new ModelAndView("cabangBcaf/_form");
		CabangBcaf item = this.repo.findById(id).orElse(null);
		view.addObject("objCabangBcaf", item);
		List<CabangDs> listDs = this.dsRepo.findAll();
		view.addObject("listDs", listDs);
		return view;
	}
	
	@GetMapping(value="list")
	public ModelAndView list() {
		ModelAndView view = new ModelAndView("cabangBcaf/_list");
		List<CabangBcaf> list = this.repo.findAll();
		view.addObject("list",list);
		return view;
	}
	
	@GetMapping(value="hapus/{id}")
	public ModelAndView hapus(@PathVariable("id") Long id) {
		ModelAndView view = new ModelAndView("cabangBcaf/_hapus");
		CabangBcaf item = this.repo.findById(id).orElse(null);
		view.addObject("objCabangBcaf", item);
		return view;
	}
	
	@PostMapping(value="remove")
	public ModelAndView remove(@ModelAttribute CabangBcaf objCabangBcaf) {
		
		this.repo.delete(objCabangBcaf);
		ModelAndView view = new ModelAndView("cabangBcaf/_form");
		view.addObject("objCabangBcaf", new CabangBcaf());
		return view;
	}
}
