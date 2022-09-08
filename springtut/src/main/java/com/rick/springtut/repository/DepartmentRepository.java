package com.rick.springtut.repository;

import com.rick.springtut.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    public Optional<Department> findByDepartmentNameIgnoreCase(String departmentNAme);


}
