package com.example.demo.service;

import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.dto.DepartmentDTO;
import com.example.demo.service.dto.EmployeeDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long empID) {
        return employeeRepository.findById(empID);
    }
    public Employee createEmployee(Long deptID, EmployeeDTO employeeDTO) {
        Optional<Department> department = departmentRepository.findById(deptID);

        Employee employee = new Employee();
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setGender(employeeDTO.getGender());
        employee.setMiddleName(employeeDTO.getMiddleName());
        employee.setSalary(employeeDTO.getSalary());
        employee.setDateOfBirth(employeeDTO.getDateOfBirth());
        if (department.isPresent())
            employee.setDepartment(department.get());
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long employeeId, EmployeeDTO employeeDTO) {
        Employee employee = getEmployeeById(employeeId).get();
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setMiddleName(employeeDTO.getMiddleName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setGender(employeeDTO.getGender());
        employee.setSalary(employeeDTO.getSalary());
        employee.setDateOfBirth(employeeDTO.getDateOfBirth());
        return employeeRepository.save(employee);
    }

    public void deleteEmployeeById(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }


    public List <Employee> getEmployeeByLastNameAndFirstName (String lastName, String firstName){
        return employeeRepository.findByLastNameAndFirstName(lastName,firstName);
    }

    public List <Employee> getEmployeeByFirstNameLike (String firstName){
        return employeeRepository.findByFirstNameLike("%"+firstName+"%");
    }

    public List <Employee> getEmployeeByFirstNameNotLike (String firstName){
        return employeeRepository.findByFirstNameNotLike(firstName);
    }

    public List<Employee> getEmployeeByLastNameNot (String lastName){
        return employeeRepository.findByLastNameNot(lastName);
    }
    public List <Employee> getEmployeeBySalaryGreaterThan (int salary){
        return employeeRepository.findBySalaryGreaterThan(salary);
    }


}
