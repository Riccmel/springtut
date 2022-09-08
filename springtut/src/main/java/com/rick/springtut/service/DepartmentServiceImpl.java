package com.rick.springtut.service;

import com.rick.springtut.entity.Department;
import com.rick.springtut.error.DepartmentNotFoundExeption;
import com.rick.springtut.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department departmentById(Long departmentId) throws DepartmentNotFoundExeption {
        Optional<Department> department = departmentRepository.findById(departmentId);
        if(!department.isPresent()){
            throw new DepartmentNotFoundExeption("Department Not Available");
        }
        return department.get();
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        Department depDB = departmentRepository.findById(departmentId).get();

        if(Objects.nonNull(department.getDepartmentName()) && ! "".equalsIgnoreCase(department.getDepartmentName())){
            depDB.setDepartmentName(department.getDepartmentName());
        }
        if(Objects.nonNull(department.getDepartmentCode()) && ! "".equalsIgnoreCase(department.getDepartmentCode())){
            depDB.setDepartmentCode(department.getDepartmentCode());
        }
        if(Objects.nonNull(department.getDepartmentAddress()) && ! "".equalsIgnoreCase(department.getDepartmentAddress())){
            depDB.setDepartmentAddress(department.getDepartmentAddress());
        }
    return departmentRepository.save(depDB);

    }

    @Override
    public Optional<Department> fetchDepartmentByName(String departmentName) {
        Optional<Department> opt =  departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
        return opt;
    }
}
