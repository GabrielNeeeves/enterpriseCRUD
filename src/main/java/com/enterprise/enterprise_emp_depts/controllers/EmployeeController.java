package com.enterprise.enterprise_emp_depts.controllers;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enterprise.enterprise_emp_depts.domain.DepartmentEntity;
import com.enterprise.enterprise_emp_depts.domain.EmployeeEntity;
import com.enterprise.enterprise_emp_depts.repositories.EmployeesRepository;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    
    @Autowired
    private EmployeesRepository empRepository;

    //GET
    @GetMapping
    public List<EmployeeEntity> getAllEmployees() {
        
        return empRepository.findAll();
    }

    //POST
    @PostMapping
    public void createEmp(@RequestBody EmployeeEntity emp) {

        empRepository.save(emp);
    }

    //DELTE
    @DeleteMapping("/{id}")
    public void deleteEmp(@PathVariable Long id) {

        empRepository.deleteById(id);
    }
    
    //PUT
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeEntity> updateEmp(@PathVariable Long id, @RequestBody EmployeeEntity updatedEmployee) {

        EmployeeEntity emp = empRepository.findById(id)
            .orElseThrow();

        emp.setName(updatedEmployee.getName());

        EmployeeEntity savedEmployee = empRepository.save(emp);
        
        return ResponseEntity.ok(updatedEmployee);
    }
}
