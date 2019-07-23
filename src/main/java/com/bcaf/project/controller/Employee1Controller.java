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

import com.bcaf.project.model.Employee1;
import com.bcaf.project.repository.Employee1Repo;

@Controller
@RequestMapping(value="/employee1/")
public class Employee1Controller {
	
	@Autowired
	private Employee1Repo repo;
	
	@GetMapping(value = "index")
	public ModelAndView index() {
		ModelAndView view = new ModelAndView("employee1/index");
		List<Employee1> list = this.repo.findAll();
		view.addObject("list", list);
		return view;
	}
	
	@GetMapping(value = "create")
	public ModelAndView create() {
		ModelAndView view = new ModelAndView("employee1/_form");
		view.addObject("objEmployee", new Employee1()); //itu yg "provinsi" itu diliat dari th:object di file _form.html
		return view;
	}
	
	@PostMapping(value = "save")
	public ModelAndView save(@ModelAttribute Employee1 objEmployee, BindingResult result) {
		ModelAndView view = new ModelAndView("employee1/_form");
		if(result.hasErrors()) {
			view.addObject("objEmployee", objEmployee);
		}
		else {
			this.repo.save(objEmployee);
			view.addObject("objEmployee", new Employee1());
		}
		
		return view;
		
	}
	
	@GetMapping(value="edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		ModelAndView view = new ModelAndView("employee1/_form");
		Employee1 item = this.repo.findById(id).orElse(null);
		view.addObject("objEmployee", item);
		return view;
	}
	
	@GetMapping(value="list")
	public ModelAndView list() {
		ModelAndView view = new ModelAndView("employee1/_list");
		List<Employee1> list = this.repo.findAll();
		view.addObject("list",list);
		return view;
	}
	
	@GetMapping(value="hapus/{id}")
	public ModelAndView hapus(@PathVariable("id") Long id) {
		ModelAndView view = new ModelAndView("employee1/_hapus");
		Employee1 item = this.repo.findById(id).orElse(null);
		view.addObject("objEmployee", item);
		return view;
	}
	
	@PostMapping(value="remove")
	public ModelAndView remove(@ModelAttribute Employee1 objEmployee) {
		
		this.repo.delete(objEmployee);
		ModelAndView view = new ModelAndView("employee1/_form");
		view.addObject("objEmployee", new Employee1());
		return view;
	}
}
