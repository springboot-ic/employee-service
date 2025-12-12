package com.ic.employee_service.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @PostMapping
    public ResponseEntity<Map<String, Object>> createEmployee(@RequestBody Map<String, Object> request) {

        Map<String, Object> dummy = new HashMap<>();
        dummy.put("empId", UUID.randomUUID());
        dummy.put("firstname", request.get("firstname"));
        dummy.put("lastname", request.get("lastname"));
        dummy.put("designation", request.get("designation"));
        dummy.put("department", request.get("department"));
        dummy.put("salary", request.get("salary"));
        dummy.put("status", request.get("status"));

        return ResponseEntity.ok(dummy);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getEmployeeById(@PathVariable UUID id) {

        Map<String, Object> dummy = new HashMap<>();
        dummy.put("empId", id);
        dummy.put("firstname", "John");
        dummy.put("lastname", "Doe");
        dummy.put("designation", "JUNIOR_DEVELOPER");
        dummy.put("department", "ENGINEERING");
        dummy.put("salary", new BigDecimal("50000"));
        dummy.put("status", "ACTIVE");

        return ResponseEntity.ok(dummy);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateEmployee(
            @PathVariable UUID id,
            @RequestBody Map<String, Object> request) {

        Map<String, Object> updated = new HashMap<>();
        updated.put("empId", id);
        updated.put("firstname", request.getOrDefault("firstname", "John"));
        updated.put("lastname", request.getOrDefault("lastname", "Doe"));
        updated.put("designation", request.getOrDefault("designation", "JUNIOR_DEVELOPER"));
        updated.put("department", request.getOrDefault("department", "ENGINEERING"));
        updated.put("salary", request.getOrDefault("salary", new BigDecimal("50000")));
        updated.put("status", request.getOrDefault("status", "ACTIVE"));

        return ResponseEntity.ok(updated);
    }

    @GetMapping
    public ResponseEntity<List<Map<String, Object>>> getAllEmployees() {

        Map<String, Object> e1 = new HashMap<>();
        e1.put("empId", UUID.randomUUID());
        e1.put("firstname", "Alice");
        e1.put("lastname", "Johnson");
        e1.put("designation", "SENIOR_DEVELOPER");
        e1.put("department", "ENGINEERING");
        e1.put("salary", new BigDecimal("70000"));
        e1.put("status", "ACTIVE");

        Map<String, Object> e2 = new HashMap<>();
        e2.put("empId", UUID.randomUUID());
        e2.put("firstname", "Bob");
        e2.put("lastname", "Williams");
        e2.put("designation", "QA_ENGINEER");
        e2.put("department", "QUALITY_ASSURANCE");
        e2.put("salary", new BigDecimal("45000"));
        e2.put("status", "INACTIVE");

        return ResponseEntity.ok(List.of(e1, e2));
    }
}
