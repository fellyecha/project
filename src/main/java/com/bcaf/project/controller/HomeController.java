package com.bcaf.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@RequestMapping(value="/home")
	public ModelAndView index() {
		ModelAndView view = new ModelAndView("/home/index");
		return view;
	}
	
	@RequestMapping(value="/admin")
	public ModelAndView admin() {
		ModelAndView view = new ModelAndView("/home/admin");
		return view;
	}
	
	@RequestMapping(value="/manager")
	public ModelAndView manager() {
		ModelAndView view = new ModelAndView("/home/manager");
		return view;
	}
	
}
