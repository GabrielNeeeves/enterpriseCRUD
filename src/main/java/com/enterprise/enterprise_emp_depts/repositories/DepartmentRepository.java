package com.enterprise.enterprise_emp_depts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enterprise.enterprise_emp_depts.domain.DepartmentEntity;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long>{
    
}
