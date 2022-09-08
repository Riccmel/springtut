package com.rick.springtut.service;

import com.rick.springtut.entity.Department;
import com.rick.springtut.error.DepartmentNotFoundExeption;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {

    public Department saveDepartment(Department department);

    public List<Department> fetchDepartmentList();

    public Department departmentById(Long departmentId) throws DepartmentNotFoundExeption;

    public void deleteDepartmentById(Long departmentId);

    public Department updateDepartment(Long departmentId, Department department);

    public Optional<Department> fetchDepartmentByName(String departmentName);
}
