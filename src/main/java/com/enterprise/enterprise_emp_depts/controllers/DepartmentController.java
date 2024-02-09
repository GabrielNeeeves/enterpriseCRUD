package com.enterprise.enterprise_emp_depts.controllers;

import java.util.List;

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
import com.enterprise.enterprise_emp_depts.repositories.DepartmentRepository;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    
    @Autowired
    private DepartmentRepository departmentRepository;

    //GET
    @GetMapping
    public List<DepartmentEntity> getDepts() {

        List<DepartmentEntity> listaDepts = departmentRepository.findAll();
        return listaDepts;
    }

    //POST
    @PostMapping
    public void createDept(@RequestBody DepartmentEntity dept) {

        departmentRepository.save(dept);
    }

    //DELETE 
    @DeleteMapping("/{id}")
    public void deleteDept(@PathVariable Long id) {

        departmentRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepartmentEntity> updateDept(@PathVariable Long id, @RequestBody DepartmentEntity updatedDepartment) {

        DepartmentEntity department  = departmentRepository.findById(id)
            .orElseThrow();

        department.setName(updatedDepartment.getName());

        DepartmentEntity savedDepartment = departmentRepository.save(department);
        
        return ResponseEntity.ok(savedDepartment);
    }
    
}
