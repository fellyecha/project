package com.bcaf.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bcaf.project.model.KabKotCabang;
import com.bcaf.project.repository.KabKotCabangRepo;

@Controller
@RequestMapping(value="/kabkotCabang/")
public class KabKotCabangController {
	
	@Autowired
	private KabKotCabangRepo repo;
	
	@GetMapping(value = "index")
	public ModelAndView index() {
		ModelAndView view = new ModelAndView("kabkotCabang/index");
		List<KabKotCabang> list = this.repo.findAll();
		view.addObject("list", list);
		return view;
	}

}
