package com.rafaeldeluca.springjpalazy.repositories;

import com.rafaeldeluca.springjpalazy.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
