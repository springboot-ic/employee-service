package com.ic.employee_service.repository;

import com.ic.employee_service.entity.Employee;
import com.ic.employee_service.enums.EmployeeStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, UUID> {

    // Fetch active employees
    List<Employee> findByStatus(EmployeeStatus status);

    // Search by department
    List<Employee> findByDepartment(com.ic.employee_service.enums.Department department);

    // Search by designation
    List<Employee> findByDesignation(com.ic.employee_service.enums.Designation designation);
}

