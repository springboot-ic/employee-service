package com.ic.employee_service.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.ic.employee_service.dto.EmployeeRequestDTO;
import com.ic.employee_service.dto.EmployeeResponseDTO;
import com.ic.employee_service.entity.Employee;
import com.ic.employee_service.mapper.EmployeeMapper;
import com.ic.employee_service.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository; //Tool to talk to the database

    // CREATE
    public EmployeeResponseDTO createEmployee(EmployeeRequestDTO dto) {
        Employee employee = EmployeeMapper.toEntity(dto);
        Employee saved = employeeRepository.save(employee);
        return EmployeeMapper.toDTO(saved);
    }

    // GET all
    public List<EmployeeResponseDTO> getAllEmployees() {
        return employeeRepository.findAll()
                .stream()
                .map(EmployeeMapper::toDTO)
                .toList();
    }

    // GET by ID
    public EmployeeResponseDTO getEmployeeById(UUID id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
        return EmployeeMapper.toDTO(employee);
    }

    // UPDATE employee
    public EmployeeResponseDTO updateEmployee(UUID id, EmployeeRequestDTO dto) {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));

        employee.setFirstname(dto.getFirstname());
        employee.setLastname(dto.getLastname());
        employee.setDesignation(dto.getDesignation());
        employee.setDepartment(dto.getDepartment());
        employee.setSalary(dto.getSalary());
        employee.setStatus(dto.getStatus());

        Employee updatedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.toDTO(updatedEmployee);
    }

}
