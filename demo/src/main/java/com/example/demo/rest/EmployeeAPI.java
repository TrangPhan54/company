package com.example.demo.rest;

import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import com.example.demo.service.dto.DepartmentDTO;
import com.example.demo.service.dto.EmployeeDTO;
import org.springframework.data.repository.query.Param;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value ="/api/employees")
public interface EmployeeAPI {

    @GetMapping
    ResponseEntity<List<Employee>> getAllEmployee();

    @GetMapping(value = "/{employeeId}")
    ResponseEntity<Optional<Employee>> getEmployeeByID(@PathVariable("employeeId") Long employeeId);

    @PostMapping(value = "/{deptID}")
    ResponseEntity<Employee> createEmployee(@PathVariable ("deptID") Long deptID,
                                            @RequestBody EmployeeDTO employeeDTO);

    @PutMapping(value = "/{employeeID}")
    ResponseEntity<Employee> updateEmployee(@PathVariable("employeeID") Long employeeID,
                                            @RequestBody EmployeeDTO employeeDTO);


    @DeleteMapping(value = "/{employeeId}")
    ResponseEntity<Employee> deleteEmployeeById(@PathVariable("employeeId") Long employeeID);


    @GetMapping (value = "/lastNameAndFirstName")
    ResponseEntity <List<Employee>> getEmployeeByLastNameAndFirstName (@RequestParam("lastName") String lastName,@RequestParam("firstName") String firstName);


    @GetMapping(value = "/employee_like")
    ResponseEntity<List<Employee>> getEmployeeByFirstNameLike(@RequestParam("firstName") String firstName);


    @GetMapping(value ="/employee_not_like")
    ResponseEntity<List<Employee>> getEmployeeByFirstNameNotLike (@RequestParam ("firstName") String firstName);


    @GetMapping(value = "/last_name_not")
    ResponseEntity<List<Employee>> getEmployeeByLastNameNot (@RequestParam ("lastName") String lastName);

    @GetMapping(value = "/salary")
    ResponseEntity<List<Employee>> getEmployeeBySalaryGreaterThan (@RequestParam ("salary") int salary);



}
