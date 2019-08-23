package com.bcaf.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bcaf.project.model.Provinsi;
import com.bcaf.project.model.Response;
import com.bcaf.project.repository.ProvinsiRepo;

@RestController
@RequestMapping(value="/api/provinsi")
public class ApiProvinsiController {
	
	@Autowired
	private ProvinsiRepo repo;
	//interface adalah kumpulan method. untuk dapat dilakukan harus ada implement nya
	
	@GetMapping(value="/")
	public List<Provinsi> list(){
		return this.repo.findAll();
		//findAll itu method yg ada di JpaRepository
		//makanya bisa dipake disini
	}
	
	@GetMapping(value="/{id}")
	public Provinsi detail(@PathVariable("id") Long id) {
		return this.repo.findById(id).orElse(null);
	}
	
	@PostMapping(value = "/create")
	public ResponseEntity<Response> save(@RequestBody @Validated Provinsi item) {
		String curMethodName = new Throwable().getStackTrace()[0].getMethodName();

		Response response = new Response();
		response.setService(this.getClass().getName() + " - " + curMethodName);
		response.setMessage("Berhasil Simpan");
		response.setData(item);

		this.repo.save(item);

		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
	}
}
