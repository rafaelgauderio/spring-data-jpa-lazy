package com.rafaeldeluca.springjpalazy.services;

import java.util.List;
import java.util.Optional;

import com.rafaeldeluca.springjpalazy.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rafaeldeluca.springjpalazy.dto.DepartmentDTO;
import com.rafaeldeluca.springjpalazy.dto.EmployeeMinDTO;
import com.rafaeldeluca.springjpalazy.entities.Department;
import com.rafaeldeluca.springjpalazy.repositories.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository repository;

	@Transactional(readOnly = true)
	public DepartmentDTO findById(Long id) {
		Optional<Department> result = repository.findById(id);
		return new DepartmentDTO(result.get());
	}

	@Transactional(readOnly = true)
	public List<EmployeeMinDTO> findEmployeesByDepartment(Long id) {
		Optional<Department> result = repository.findById(id);

		// Por padrão na jpa o carregamento das entidades associadas é feito
		// EAGER : para um
		// LAZY: para muitos
		// Mas é possível alterar esse comportamento padrão para deixar a consulta mais rápida (trocar de lazy para eager)

		List<Employee> list = result.get().getEmployees();
		return list.stream().map(x -> new EmployeeMinDTO(x)).toList();
	}
}
