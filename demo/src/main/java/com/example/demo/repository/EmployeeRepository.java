package com.example.demo.repository;

import com.example.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository <Employee, Long> {

    List<Employee> findByLastNameAndFirstName(String lastName, String firstName);

    List<Employee> findByFirstNameLike (String firstName);

    List<Employee> findByFirstNameNotLike (String firstName);

    List <Employee> findByLastNameNot (String lastName);

    List <Employee> findBySalaryGreaterThan(int salary);
}
