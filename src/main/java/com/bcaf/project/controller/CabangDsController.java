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

import com.bcaf.project.model.CabangDs;
import com.bcaf.project.repository.CabangBcafRepo;
import com.bcaf.project.repository.CabangDsRepo;

@Controller
@RequestMapping(value="/cabangDs/")
public class CabangDsController {
	@Autowired
	private CabangDsRepo repo;
	
	@Autowired
	private CabangBcafRepo cabBcafRepo;
	
	@GetMapping(value = "index")
	public ModelAndView index() {
		ModelAndView view = new ModelAndView("cabangDs/index");
		List<CabangDs> list = this.repo.findAll();
		view.addObject("list", list);
		return view;
	}
	
	@GetMapping(value = "create")
	public ModelAndView create() {
		ModelAndView view = new ModelAndView("cabangDs/_form");
		view.addObject("objCabangDs", new CabangDs()); //itu yg "provinsi" itu diliat dari th:object di file _form.html
		return view;
	}
	
	@PostMapping(value = "save")
	public ModelAndView save(@ModelAttribute CabangDs objCabangDs, BindingResult result) {
		ModelAndView view = new ModelAndView("cabangDs/_form");
		if(result.hasErrors()) {
			view.addObject("objCabangDs", objCabangDs);
		}
		else {
			this.repo.save(objCabangDs);
			view.addObject("objCabangDs", new CabangDs());
		}
		
		return view;
		
	}
	
	@GetMapping(value="edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		ModelAndView view = new ModelAndView("cabangDs/_form");
		CabangDs item = this.repo.findById(id).orElse(null);
		view.addObject("objCabangDs", item);
		return view;
	}
	
	@GetMapping(value="list")
	public ModelAndView list() {
		ModelAndView view = new ModelAndView("cabangDs/_list");
		List<CabangDs> list = this.repo.findAll();
		view.addObject("list",list);
		return view;
	}
	
	@GetMapping(value="hapus/{id}")
	public ModelAndView hapus(@PathVariable("id") Long id) {
		ModelAndView view = new ModelAndView("cabangDs/_hapus");
		CabangDs item = this.repo.findById(id).orElse(null);
		view.addObject("objCabangDs", item);
		return view;
	}
	
	@PostMapping(value="remove")
	public ModelAndView remove(@ModelAttribute CabangDs objCabangDs) {
		
//		this.repo.delete(objCabangDs);
//		ModelAndView view = new ModelAndView("cabangDs/_form");
//		view.addObject("objCabangDs", new CabangDs());
//		return view;
		
		ModelAndView view = new ModelAndView("cabangDs/_form");
		if(this.cabBcafRepo.findByIdCabangDs(objCabangDs.getId()).size()==0) {
			this.repo.delete(objCabangDs);
			view.addObject("objCabangDs", new CabangDs());
		}else {
			view.addObject("objCabangDs", new CabangDs());
		}
		return view;
	}
}
