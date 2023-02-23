package com.rafaeldeluca.springjpalazy.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rafaeldeluca.springjpalazy.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	// cláusula JOIN FETCH não funciona para byscas paginadas no Spring
	// consulta JPQL
	@Query("SELECT objeto " +
			"FROM Employee objeto " +
			"JOIN FETCH objeto.department")
	List<Employee> findEmployeesWithDepartments();
}
