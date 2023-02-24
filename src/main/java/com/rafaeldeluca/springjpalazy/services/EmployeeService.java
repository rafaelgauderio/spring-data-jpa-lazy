package com.rafaeldeluca.springjpalazy.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.rafaeldeluca.springjpalazy.dto.EmployeeDepartmentDTO;
import com.rafaeldeluca.springjpalazy.entities.Employee;
import com.rafaeldeluca.springjpalazy.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rafaeldeluca.springjpalazy.dto.EmployeeMinDTO;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;

	// anotation @Transactional assegura resolução de todas as pendências "lazy" com o database
	// readOnly=true não vai fazer o look de escrita e a consulta via ficar mais rápida
	@Transactional(readOnly = true)
	public EmployeeMinDTO findByIdMin(Long id) {
		Optional<Employee> result = repository.findById(id);
		return new EmployeeMinDTO(result.get());
	}

	@Transactional(readOnly = true)
	public EmployeeDepartmentDTO findByIdWithDepartment(Long id) {
		Optional<Employee> result = repository.findById(id);
		return new EmployeeDepartmentDTO(result.get());
	}
	
	@Transactional(readOnly = true)
	public List<EmployeeDepartmentDTO> findEmployeesWithDepartments() {
		List<Employee> result = repository.findEmployeesWithDepartments();
		return result.stream().map(x -> new EmployeeDepartmentDTO(x)).collect(Collectors.toList());
	}	
}
