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

import com.bcaf.project.model.Kelurahan;
import com.bcaf.project.repository.KelurahanRepo;

@RestController
@RequestMapping(value="/api/kelurahan")
public class ApiKelurahanController {
	
	@Autowired
	private KelurahanRepo repo;
	
	@GetMapping(value="/")
	public List<Kelurahan> list(){
		return this.repo.findAll();
	}
	
	@GetMapping(value="/{id}")
	public Kelurahan detail(@PathVariable("id") Long id) {
		return this.repo.findById(id).orElse(null);
	}
	
	@PostMapping(value="/")
	public ResponseEntity<Kelurahan> save(@RequestBody Kelurahan item){
		ResponseEntity<Kelurahan> result = null;
		try {
			this.repo.save(item);
			result = new ResponseEntity<Kelurahan>(HttpStatus.OK);
		} catch (Exception e) {
			result = new ResponseEntity<Kelurahan>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
}
