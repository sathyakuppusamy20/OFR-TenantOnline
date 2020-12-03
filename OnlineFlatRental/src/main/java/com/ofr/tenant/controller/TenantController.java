package com.ofr.tenant.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ofr.tenant.entities.Tenant;
import com.ofr.tenant.exception.TenantNotFoundException;
import com.ofr.tenant.service.TenantService;
import com.ofr.tenant.service.TenantServiceImpl;

@RestController
@Validated
@RequestMapping("/tenant")
public class TenantController {
	@Autowired
	TenantServiceImpl service;
	
	@PostMapping("/add")
	public ResponseEntity<Boolean> add(@Valid@RequestBody Tenant tenant) {
		 service.addTenant(tenant);
		@SuppressWarnings({ "unchecked", "rawtypes" })
		ResponseEntity<Boolean> responseEntity = new ResponseEntity(true, HttpStatus.OK);
		return responseEntity;
	}

	@PutMapping("/update")
	public ResponseEntity<Boolean> update(@Valid@RequestBody Tenant tenant) throws TenantNotFoundException {
		 service.updateTenant(tenant);
		@SuppressWarnings({ "unchecked", "rawtypes" })
		ResponseEntity<Boolean> responseEntity = new ResponseEntity(true, HttpStatus.OK);
		return responseEntity;
	}

	@DeleteMapping("/delete")
	public ResponseEntity<Boolean> delete(@RequestBody Tenant tenant) throws TenantNotFoundException {
		 service.deleteTenant(tenant);
		@SuppressWarnings({ "rawtypes", "unchecked" })
		ResponseEntity<Boolean> responseEntity = new ResponseEntity(true, HttpStatus.OK);
		return responseEntity;
}
	@GetMapping("/all") 
	public ResponseEntity<List<Tenant>> viewAllTenant() {
		List<Tenant> list = service.viewAllTenant();
		return new ResponseEntity<List<Tenant>>(list, new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping("/find/{tenantId}")
	public ResponseEntity<Optional<Tenant>> getTenantById(@PathVariable("tenantId") Integer id) throws TenantNotFoundException {
		Optional<Tenant> tenant = service.viewTenant(id);
		@SuppressWarnings({ "rawtypes", "unchecked" })
		ResponseEntity<Optional<Tenant>> responseEntity = new ResponseEntity(tenant, HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping("/exists/{tenantId}")
	public ResponseEntity<Boolean> getExistsById(@PathVariable("tenantId") Integer id) throws TenantNotFoundException {
		boolean tenant = service.validateTenant(id);
		@SuppressWarnings({ "rawtypes", "unchecked" })
		ResponseEntity<Boolean> responseEntity = new ResponseEntity(tenant, HttpStatus.OK);
		return responseEntity;
	}
}
