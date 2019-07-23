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

import com.bcaf.project.model.CabangBca;
import com.bcaf.project.model.CabangKkbBca;
import com.bcaf.project.repository.CabangBcaRepo;
import com.bcaf.project.repository.CabangKkbBcaRepo;

@Controller
@RequestMapping(value = "/cabangBca/")
public class CabangBcaController {
	
	@Autowired
	private CabangBcaRepo repo;
	
	@Autowired
	private CabangKkbBcaRepo kkbRepo;
	
	@GetMapping(value = "index")
	public ModelAndView index() {
		ModelAndView view = new ModelAndView("cabangBca/index");
		List<CabangBca> list = this.repo.findAll();
		view.addObject("list", list);
		return view;
	}
	
	@GetMapping(value = "create")
	public ModelAndView create() {
		ModelAndView view = new ModelAndView("cabangBca/_form");	
		view.addObject("objCabangBca", new CabangBca());
		List<CabangKkbBca> listKkb = this.kkbRepo.findAll();
		view.addObject("listKkb", listKkb);
		return view;
	}
	
	@PostMapping(value = "save")
	public ModelAndView save(@ModelAttribute CabangBca objCabangBca, BindingResult result) {
		ModelAndView view = new ModelAndView("cabangBca/_form");
		if(result.hasErrors()) {
			view.addObject("objCabangBca", objCabangBca);
		}
		else {
			this.repo.save(objCabangBca);
			view.addObject("objCabangBca", new CabangBca());
		}
		
		return view;
		
	}
	
	@GetMapping(value="edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		ModelAndView view = new ModelAndView("cabangBca/_form");
		CabangBca item = this.repo.findById(id).orElse(null);
		view.addObject("objCabangBca", item);
		List<CabangKkbBca> listKkb = this.kkbRepo.findAll();
		view.addObject("listKkb", listKkb);
		return view;
	}
	
	@GetMapping(value="list")
	public ModelAndView list() {
		ModelAndView view = new ModelAndView("cabangBca/_list");
		List<CabangBca> list = this.repo.findAll();
		view.addObject("list",list);
		return view;
	}
	
	@GetMapping(value="hapus/{id}")
	public ModelAndView hapus(@PathVariable("id") Long id) {
		ModelAndView view = new ModelAndView("cabangBca/_hapus");
		CabangBca item = this.repo.findById(id).orElse(null);
		view.addObject("objCabangBca", item);
		return view;
	}
	
	@PostMapping(value="remove")
	public ModelAndView remove(@ModelAttribute CabangBca objCabangBca) {
		
		this.repo.delete(objCabangBca);
		ModelAndView view = new ModelAndView("cabangBca/_form");
		view.addObject("objCabangBca", new CabangBca());		
		return view;
	}

}
