package com.ic.employee_service.dto;

import com.ic.employee_service.enums.Department;
import com.ic.employee_service.enums.Designation;
import com.ic.employee_service.enums.EmployeeStatus;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class EmployeeRequestDTO {
    private String firstname;
    private String lastname;
    private Designation designation;
    private Department department;
    private BigDecimal salary;
    private EmployeeStatus status;
}
