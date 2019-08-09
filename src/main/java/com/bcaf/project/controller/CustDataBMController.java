package com.bcaf.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bcaf.project.model.ViewCustomerSplit;
import com.bcaf.project.repository.ViewCustomerSplitRepo;

@Controller
@RequestMapping(value = "/custDataBM/")
public class CustDataBMController {
	@Autowired
	private ViewCustomerSplitRepo repo;
	
//	@Autowired
//	private UserRoleCabangRepo urolcabRepo;
//	
//	@Autowired
//	private CabangDsRepo cabdsRepo;
	
//	@GetMapping(value = "index")
//	public ModelAndView index(@ModelAttribute CustomerData customerData) {
//		ModelAndView view = new ModelAndView("custDataBM/index");
////		List<CustomerData> list = this.repo.findByCabangDs(urolecabRepo.get)
////		List<CabangDs> listDs = this.cabdsRepo.findByCabangName(customerData.getCabangName());
//		view.addObject("listDs", listDs);
//		return view;
//		
////		List<Provinsi> listProp = this.propRepo.findAll();
////		if(this.kecRepo.findByIdKabKota(kabkota.getId()).size()==0) {
//	}
	
	@GetMapping(value = "index")
	public ModelAndView index() {
		ModelAndView view = new ModelAndView("custDataBM/index");
		List<ViewCustomerSplit> list = this.repo.findAll();
		view.addObject("list", list);
		return view;
	}
}
