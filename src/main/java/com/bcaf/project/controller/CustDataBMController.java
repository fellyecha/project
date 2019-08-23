package com.bcaf.project.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bcaf.project.model.User;
import com.bcaf.project.model.ViewCustomerData;
//import com.bcaf.project.model.ViewCustomerSplit;
import com.bcaf.project.repository.ViewCustomerDataRepo;
import com.bcaf.project.repository.ViewCustomerSplitRepo;

@Controller
@RequestMapping(value = "/custDataBM/")
public class CustDataBMController extends BaseController{
	@Autowired
	public ViewCustomerSplitRepo repo;
	
	@Autowired
	public ViewCustomerDataRepo datRepo;
	
	
//	@GetMapping(value = "index")
//	public ModelAndView index(@ModelAttribute CustomerData customerData) {
//		ModelAndView view = new ModelAndView("custDataBM/index");
////		List<CustomerData> list = this.repo.findByCabangDs(urolecabRepo.get)
//		List<CabangDs> listDs = this.cabdsRepo.findByCabangName(customerData.getCabangName());
//		view.addObject("listDs", listDs);
//		return view;
//		
////		List<Provinsi> listProp = this.propRepo.findAll();
////		if(this.kecRepo.findByIdKabKota(kabkota.getId()).size()==0) {
//	}
	
	@GetMapping(value = "index")
	public ModelAndView index() throws SQLException {
		ModelAndView view = new ModelAndView("custDataBM/index");
		List<ViewCustomerData> list = this.datRepo.findAll();
		User user = getUser();
//		String us = user.toString();
//		String url = "jdbc:sqlserver://localhost;databaseName=project_db";
//		Connection conn = DriverManager.getConnection(url, "sa", "Marf3l");
//		Statement stmt = conn.createStatement();
//		PreparedStatement ps = null;
//		String sql = "Select * From view_customer_split a "
//				+ "JOIN tbl_cabang_ds c ON a.cabang_ds = c.cabang_ds "
//				+ "JOIN tbl_user_role_cabang AS r ON c.id = r.cabang_id "
//				+ "JOIN tbl_user AS f ON r.username = f.id"
//				+ "WHERE f.username = '?'";
//		ps = conn.prepareStatement(sql);
//		ps.setString(1, us);
//		ps.executeUpdate();
		view.addObject("list", list);
		return view;
	}
	
	@GetMapping(value="edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		ModelAndView view = new ModelAndView("custDataBM/_form");
		ViewCustomerData item = this.datRepo.findById(id).orElse(null);
		view.addObject("objCustData", item);
		return view;
	}
	
	@PostMapping(value = "save")
	public ModelAndView save(@ModelAttribute ViewCustomerData objCustData, BindingResult result) {
		ModelAndView view = new ModelAndView("custDataBM/_form");
		if(result.hasErrors()) {
			view.addObject("objCustData", objCustData);
		}
		else {
			this.datRepo.save(objCustData);
			view.addObject("objCustData", new ViewCustomerData());
		}
		
		return view;
		
	}

	@GetMapping(value = "list")
	public ModelAndView list() {
		ModelAndView view = new ModelAndView("custDataBM/_list");
		List<ViewCustomerData> list = this.datRepo.findAll();
		view.addObject("list", list);
		return view;
	}
}
