package com.example.demo.service.dto;

import com.example.demo.entity.Gender;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class EmployeeDTO {
    private Long employeeID;
    private LocalDate dateOfBirth;
    private String firstName;
    private Gender gender;
    private String lastName;
    private String middleName;
    private int salary;
}
