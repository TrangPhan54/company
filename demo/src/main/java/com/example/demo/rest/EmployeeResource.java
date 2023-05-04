package com.example.demo.rest;

import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.dto.EmployeeDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class EmployeeResource implements EmployeeAPI {

    @Autowired
    private final EmployeeService employeeService;

    @Override
    public ResponseEntity<List<Employee>> getAllEmployee() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @Override
    public ResponseEntity<Optional<Employee>> getEmployeeByID(Long employeeId) {
        return ResponseEntity.ok(employeeService.getEmployeeById(employeeId));
    }

    @Override
    public ResponseEntity<Employee> createEmployee(Long deptID, EmployeeDTO employeeDTO) {
        Employee emp = employeeService.createEmployee(deptID, employeeDTO);
        return ResponseEntity.created(URI.create("/api/employees" + emp.getEmployeeID())).body(emp);
    }

    @Override
    public ResponseEntity<Employee> updateEmployee(Long employeeID, EmployeeDTO employeeDTO) {
        Employee employee = employeeService.updateEmployee(employeeID, employeeDTO);
        return ResponseEntity.created(URI.create("/api/employees/" + employee.getEmployeeID())).body(employee);
    }

    @Override
    public ResponseEntity<Employee> deleteEmployeeById(Long employeeID) {
        employeeService.deleteEmployeeById(employeeID);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<List<Employee>> getEmployeeByLastNameAndFirstName(String lastName, String firstName) {
        return ResponseEntity.ok(employeeService.getEmployeeByLastNameAndFirstName(lastName, firstName));
    }

    @Override
    public ResponseEntity<List<Employee>> getEmployeeByFirstNameLike(String firstName) {
        return ResponseEntity.ok(employeeService.getEmployeeByFirstNameLike(firstName));
    }

    @Override
    public ResponseEntity<List<Employee>> getEmployeeByFirstNameNotLike(String firstName) {
        return ResponseEntity.ok(employeeService.getEmployeeByFirstNameLike(firstName));
    }

    @Override
    public ResponseEntity<List<Employee>> getEmployeeByLastNameNot(String lastName) {
        return ResponseEntity.ok(employeeService.getEmployeeByLastNameNot(lastName));
    }

    @Override
    public ResponseEntity<List<Employee>> getEmployeeBySalaryGreaterThan(int salary) {
        return ResponseEntity.ok(employeeService.getEmployeeBySalaryGreaterThan(salary));
    }

}