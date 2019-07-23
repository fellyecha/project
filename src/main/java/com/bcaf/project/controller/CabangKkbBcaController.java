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
@RequestMapping(value = "/cabangKkbBca/")
public class CabangKkbBcaController {
	@Autowired
	private CabangKkbBcaRepo repo;
	
	@Autowired
	private CabangBcaRepo bcaRepo;
	
	@GetMapping(value = "index")
	public ModelAndView index() {
		ModelAndView view = new ModelAndView("cabangKkbBca/index");
		List<CabangKkbBca> list = this.repo.findAll();
		view.addObject("list", list);
		return view;
	}
	
	@GetMapping(value = "create")
	public ModelAndView create() {
		ModelAndView view = new ModelAndView("cabangKkbBca/_form");	
		view.addObject("objCabangKkb", new CabangKkbBca());
		List<CabangBca> listBca = this.bcaRepo.findAll();
		view.addObject("listBca", listBca);
		return view;
	}
	
	@PostMapping(value = "save")
	public ModelAndView save(@ModelAttribute CabangKkbBca objCabangKkb, BindingResult result) {
		ModelAndView view = new ModelAndView("cabangKkbBca/_form");
		if(result.hasErrors()) {
			view.addObject("objCabangKkb", objCabangKkb);
		}
		else {
			this.repo.save(objCabangKkb);
			view.addObject("objCabangKkb", new CabangKkbBca());
		}
		
		return view;
		
	}
	
	@GetMapping(value="edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		ModelAndView view = new ModelAndView("cabangKkbBca/_form");
		CabangKkbBca item = this.repo.findById(id).orElse(null);
		view.addObject("objCabangKkb", item);
		return view;
	}
	
	@GetMapping(value="list")
	public ModelAndView list() {
		ModelAndView view = new ModelAndView("cabangKkbBca/_list");
		List<CabangKkbBca> list = this.repo.findAll();
		view.addObject("list",list);
		return view;
	}
	
	@GetMapping(value="hapus/{id}")
	public ModelAndView hapus(@PathVariable("id") Long id) {
		ModelAndView view = new ModelAndView("cabangKkbBca/_hapus");
		CabangKkbBca item = this.repo.findById(id).orElse(null);
		view.addObject("objCabangKkb", item);
		return view;
	}
	
	@PostMapping(value="remove")
	public ModelAndView remove(@ModelAttribute CabangKkbBca objCabangKkb) {
		
		ModelAndView view = new ModelAndView("cabangKkbBca/_form");
		if(this.bcaRepo.findByIdCabangKkbBca(objCabangKkb.getId()).size()==0) {
			this.repo.delete(objCabangKkb);
			view.addObject("objCabangKkb", new CabangKkbBca());
		}else {
			view.addObject("objCabangKkb", new CabangKkbBca());
		}
		return view;
	}

}
