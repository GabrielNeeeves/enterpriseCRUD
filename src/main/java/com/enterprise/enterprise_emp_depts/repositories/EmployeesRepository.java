package com.enterprise.enterprise_emp_depts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enterprise.enterprise_emp_depts.domain.EmployeeEntity;

public interface EmployeesRepository extends JpaRepository<EmployeeEntity, Long>{
    
}
