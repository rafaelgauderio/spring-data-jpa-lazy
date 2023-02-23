package com.rafaeldeluca.springjpalazy.controllers;

import java.util.List;

import com.rafaeldeluca.springjpalazy.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rafaeldeluca.springjpalazy.dto.DepartmentDTO;
import com.rafaeldeluca.springjpalazy.dto.EmployeeMinDTO;

@RestController
@RequestMapping(value = "/departments")
public class DepartmentController {

	@Autowired
	private DepartmentService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<DepartmentDTO> findById(@PathVariable Long id) {
		DepartmentDTO obj = service.findById(id);		
		return ResponseEntity.ok(obj);
	}
	
	@GetMapping(value = "/{id}/employees")
	public ResponseEntity<List<EmployeeMinDTO>> findEmployeesByDepartment(@PathVariable Long id) {
		List<EmployeeMinDTO> list = service.findEmployeesByDepartment(id);		
		return ResponseEntity.ok(list);
	}	
}
