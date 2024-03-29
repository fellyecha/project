package com.bcaf.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bcaf.project.model.Provinsi;
import com.bcaf.project.repository.ProvinsiRepo;

@RestController
@RequestMapping(value="/api1/provinsi")
public class ApiProvinsi1Controller {
	
	@Autowired
	private ProvinsiRepo repo;
	
	@RequestMapping(value="/")
	public List<Provinsi> list(){
		return this.repo.findAll();
		//findAll().. method g ada di jparepository
	}
	
	@RequestMapping(value="/{id}")
	public Provinsi detail(@PathVariable("id") Long id) {
		return this.repo.findById(id).orElse(null);
	}
	


	@PostMapping(value="/")
	public ResponseEntity<Provinsi> save(@RequestBody Provinsi item) {
		ResponseEntity<Provinsi> result = null;
		//, MediaType.APPLICATION_JSON_UTF8_VALUE
		try {
			this.repo.save(item);
			result = new ResponseEntity<Provinsi>(HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			result = new ResponseEntity<Provinsi>(HttpStatus.INTERNAL_SERVER_ERROR);
			//internal server error 500
		}
		return result;
	}
}