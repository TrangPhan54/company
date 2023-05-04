package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "employeeID")
    private Long employeeID;
    @Column( name = "dateOfBirth")
    private LocalDate dateOfBirth;
    @Column(name = "firstName")
    private String firstName;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Column( name ="lastName")
    private String lastName;
    @Column (name = "middleName")
    private String middleName;
    @Column (name = "salary")
    private int salary;

    @ManyToOne
    @JoinColumn( name = "deptID")
    private Department department;

}
