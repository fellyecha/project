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

import com.bcaf.project.model.Kecamatan;
import com.bcaf.project.model.Kelurahan;
import com.bcaf.project.repository.KecamatanRepo;
import com.bcaf.project.repository.KelurahanRepo;

@Controller
@RequestMapping(value = "/kelurahan/")
public class KelurahanController {
	@Autowired
	private KelurahanRepo repo;
	
	@Autowired
	private KecamatanRepo kecRepo;
	
	@GetMapping(value="index")
	public ModelAndView index() {
		ModelAndView view = new ModelAndView("kelurahan/index");
		List<Kelurahan> list = this.repo.findAll();
		view.addObject("list", list);
		return view;
	}
	
	@GetMapping(value = "create")
	public ModelAndView create() {
		ModelAndView view = new ModelAndView("kelurahan/_form");
		view.addObject("kelurahan", new Kelurahan()); //itu yg "kabkota" itu diliat dari th:object di file _form.html
		
		List<Kecamatan> listKec = this.kecRepo.findAll();
		view.addObject("listKec", listKec);
		return view;
	}
	
	@PostMapping(value = "save")
	public ModelAndView save(@ModelAttribute Kelurahan kelurahan, BindingResult result) {
		ModelAndView view = new ModelAndView("kelurahan/_form");
		if(result.hasErrors()) {
			view.addObject("kelurahan", kelurahan);
		}
		else {
			this.repo.save(kelurahan);
			view.addObject("kelurahan", new Kelurahan());
		}
		
		return view;
		
	}
	
	@GetMapping(value="edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		ModelAndView view = new ModelAndView("kelurahan/_form");
		Kelurahan item = this.repo.findById(id).orElse(null);
		view.addObject("kelurahan", item);
		List<Kecamatan> listKec = this.kecRepo.findAll();
		view.addObject("listKec", listKec);
		return view;
	}
	
	@GetMapping(value="list")
	public ModelAndView list() {
		ModelAndView view = new ModelAndView("kelurahan/_list");
		List<Kelurahan> list = this.repo.findAll();
		view.addObject("list",list);
		return view;
	}
	
	@GetMapping(value="hapus/{id}")
	public ModelAndView hapus(@PathVariable("id") Long id) {
		ModelAndView view = new ModelAndView("kelurahan/_hapus");
		Kelurahan item = this.repo.findById(id).orElse(null);
		view.addObject("kelurahan", item);
		return view;
	}
	
	@PostMapping(value="remove")
	public ModelAndView remove(@ModelAttribute Kelurahan kelurahan) {
		this.repo.delete(kelurahan);
		ModelAndView view = new ModelAndView("kelurahan/_form");
		view.addObject("kelurahan", new Kelurahan());
		return view;
	}
}
