package com.bcaf.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bcaf.project.model.KabupatenKota;
import com.bcaf.project.repository.KabupatenKotaRepo;

@RestController
@RequestMapping("api/vl")
public class ApiKota2Controller {
	
	@Autowired
	private KabupatenKotaRepo repo;
	
	@GetMapping("/addresses")
	public List<KabupatenKota> getAllKota(){
		return repo.findAll();
	}
	
	@GetMapping("/addresses/{idProvinsi}")
	public List<KabupatenKota> getProvinsi(@RequestParam("idProvinsi") Long idProvinsi){
		return repo.findByIdProvinsi(idProvinsi);
	}
}
