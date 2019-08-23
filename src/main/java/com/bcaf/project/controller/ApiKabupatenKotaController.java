package com.bcaf.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bcaf.project.model.KabupatenKota;
import com.bcaf.project.repository.KabupatenKotaRepo;

@RestController
@RequestMapping(value="/api/kabkota")
public class ApiKabupatenKotaController {
	
	@Autowired
	private KabupatenKotaRepo repo;
	
//	@Autowired
//	private ProvinsiRepo provRepo;
	
	@GetMapping(value="/")
	public List<KabupatenKota> list(){
		return this.repo.findAll();
	}
	
//	@GetMapping(value="/{id}")
//	public KabupatenKota detail(@PathVariable("id") Long id) {
//		return this.repo.findById(id).orElse(null);
//	}
//	
	@GetMapping(value="/{idProvinsi}")
	public KabupatenKota detailProv(@PathVariable("idProvinsi") Long idProvinsi) {
		return this.repo.findById(idProvinsi).orElse(null);
	}
	
	@PostMapping(value="/")
	public ResponseEntity<KabupatenKota> save(@RequestBody KabupatenKota item){
		ResponseEntity<KabupatenKota> result = null;
		try {
			this.repo.save(item);
			result = new ResponseEntity<KabupatenKota>(HttpStatus.OK);
		} catch (Exception e) {
			result = new ResponseEntity<KabupatenKota>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
}
