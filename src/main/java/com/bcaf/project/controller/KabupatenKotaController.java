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

import com.bcaf.project.model.KabupatenKota;
import com.bcaf.project.model.Provinsi;
import com.bcaf.project.repository.KabupatenKotaRepo;
import com.bcaf.project.repository.KecamatanRepo;
import com.bcaf.project.repository.ProvinsiRepo;

@Controller
@RequestMapping(value = "/kabkota/")
public class KabupatenKotaController {
	
	@Autowired
	private KabupatenKotaRepo repo;
	
	@Autowired
	private ProvinsiRepo propRepo;
	
	@Autowired
	private KecamatanRepo kecRepo;
	
	@GetMapping(value="index")
	public ModelAndView index() {
		ModelAndView view = new ModelAndView("kabkota/index");
		List<KabupatenKota> list = this.repo.findAll();
		view.addObject("list", list);
		return view;
	}
	
	@GetMapping(value = "create")
	public ModelAndView create() {
		ModelAndView view = new ModelAndView("kabkota/_form");
		view.addObject("kabkota", new KabupatenKota()); //itu yg "kabkota" itu diliat dari th:object di file _form.html
		
		List<Provinsi> listProp = this.propRepo.findAll();
		view.addObject("listProp", listProp);
		return view;
	}
	
	@PostMapping(value = "save")
	public ModelAndView save(@ModelAttribute KabupatenKota kabkota, BindingResult result) {
		ModelAndView view = new ModelAndView("kabkota/_form");
		if(result.hasErrors()) {
			view.addObject("kabkota", kabkota);
		}
		else {
			this.repo.save(kabkota);
			view.addObject("kabkota", new KabupatenKota());
		}
		
		return view;
		
	}
	
	@GetMapping(value="edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		ModelAndView view = new ModelAndView("kabkota/_form");
		KabupatenKota item = this.repo.findById(id).orElse(null);
		view.addObject("kabkota", item);
		List<Provinsi> listProp = this.propRepo.findAll();
		view.addObject("listProp", listProp);
		return view;
	}
	
	@GetMapping(value="list")
	public ModelAndView list() {
		ModelAndView view = new ModelAndView("kabkota/_list");
		List<KabupatenKota> list = this.repo.findAll();
		view.addObject("list",list);
		return view;
	}
	
	@GetMapping(value="hapus/{id}")
	public ModelAndView hapus(@PathVariable("id") Long id) {
		ModelAndView view = new ModelAndView("kabkota/_hapus");
		KabupatenKota item = this.repo.findById(id).orElse(null);
		view.addObject("kabkota", item);
		return view;
	}
	
	@PostMapping(value="remove")
	public ModelAndView remove(@ModelAttribute KabupatenKota kabkota) {
		ModelAndView view = new ModelAndView("kabkota/_form");
		//#1 check data di kota
		if(this.kecRepo.findByIdKabKota(kabkota.getId()).size()==0) {
			// jika tidak ada data provinsi di kota, maka proses hapus dilakukan
			this.repo.delete(kabkota);
			view.addObject("kabkota", new KabupatenKota());
		}else {
			view.addObject("kabkota", kabkota);
		}
		return view;
	}
}
