package com.rafaeldeluca.springjpalazy.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rafaeldeluca.springjpalazy.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	@Query("SELECT obj FROM Employee obj JOIN FETCH obj.department")
	List<Employee> findEmployeesWithDepartments();
}
