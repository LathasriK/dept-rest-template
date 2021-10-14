package com.example.departmentservice.dao;

import com.example.departmentservice.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    String findByDepartmentName(String departmentName);
}
