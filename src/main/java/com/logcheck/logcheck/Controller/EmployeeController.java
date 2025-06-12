package com.logcheck.logcheck.Controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    private static final Map<Long, Employee> EMPLOYEE_DB = new HashMap<>();

    // Mock some data
    static {
        EMPLOYEE_DB.put(1L, new Employee(1L, "Alice", "HR"));
        EMPLOYEE_DB.put(2L, new Employee(2L, "Bob", "IT"));
        EMPLOYEE_DB.put(3L, new Employee(3L, "Charlie", "Finance"));
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        logger.info("Fetching all employees");
        return ResponseEntity.ok(new ArrayList<>(EMPLOYEE_DB.values()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        logger.info("Fetching employee with ID: {}", id);

        Employee employee = EMPLOYEE_DB.get(id);
        if (employee == null) {
            logger.warn("Employee with ID {} not found", id);
            return ResponseEntity.notFound().build();
        }

        logger.debug("Employee details: {}", employee.getName());
        return ResponseEntity.ok(employee);
    }

    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        logger.info("Adding new employee: {}", employee.getName());
        long newId = EMPLOYEE_DB.size() + 1;
        employee.setId(newId);
        EMPLOYEE_DB.put(newId, employee);
        logger.debug("Employee added with ID: {}", newId);
        return ResponseEntity.ok(employee);
    }
}
