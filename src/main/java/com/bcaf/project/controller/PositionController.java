package com.bcaf.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bcaf.project.model.Position;
import com.bcaf.project.model.ViewPosition;
import com.bcaf.project.repository.PositionRepo;
import com.bcaf.project.repository.ViewPositionRepo;

@Controller
@RequestMapping(value="/position/")
public class PositionController {
	
	@Autowired
	private PositionRepo repo;
	
	@Autowired
	private ViewPositionRepo viewrepo;
	
	@GetMapping(value = "index")
	public ModelAndView index() {
		ModelAndView view = new ModelAndView("position/index");
//		List<Position> list = this.repo.findAll();
//		view.addObject("list", list);
		List<ViewPosition> parent = this.viewrepo.findAllByParent();
		view.addObject("parent", parent);
		return view;
	}
	
}
