package com.rick.springtut.controller;

import com.rick.springtut.entity.Department;
import com.rick.springtut.error.DepartmentNotFoundExeption;
import com.rick.springtut.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){
        LOGGER.info("Inside saveDepartment of DepartmentController");
        return departmentService.saveDepartment(department);
    }
    @GetMapping("/departments")
    public List<Department> fetchDepartmentList(){
        return departmentService.fetchDepartmentList();
    }
    @GetMapping("/department/{id}")
    public Department departmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundExeption {
        return departmentService.departmentById(departmentId);
    }
    @DeleteMapping("(departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId){
        departmentService.deleteDepartmentById(departmentId);
        return "Department deleted Successfully";
    }
    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department){
        return departmentService.updateDepartment(departmentId, department);
    }
    @GetMapping("/departments/name/{name}")
    public ResponseEntity fetchDepartmentByName(@PathVariable("name") String departmentName){
        Optional<Department> depOpt = departmentService.fetchDepartmentByName(departmentName);
        ResponseEntity.status(HttpStatus.BAD_REQUEST).body(String.format("%s department wasn't found", departmentName));
        if(depOpt.isPresent()){
            return new ResponseEntity(depOpt.get(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

    }

}
