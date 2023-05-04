package com.example.demo.rest;

import com.example.demo.entity.Department;
import com.example.demo.service.dto.DepartmentDTO;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RequestMapping(value = "/api/departments")
public interface DepartmentAPI {
    @GetMapping
    ResponseEntity<List<Department>> getAllDepartment ();

    @GetMapping(value = "/{departmentId}")
    ResponseEntity<Optional<Department>> getDepartmentById (@PathVariable ("departmentId") Long departmentId);
    @PostMapping
    ResponseEntity <Department> createDepartment (@RequestBody DepartmentDTO departmentDTO);

    @PutMapping(value = "/{departmentId}")
    ResponseEntity<Department> updateDepartment(@PathVariable ("departmentId") Long departmentId, @RequestBody DepartmentDTO departmentDTO);

    @DeleteMapping(value = "/{departmentId}")
    ResponseEntity<Department> deleteDepartmentById (@PathVariable ("departmentId") Long departmentId);

    @GetMapping("/reports")
    ResponseEntity<List<Department>> getDepartmentByDate(@RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate);


    @GetMapping("/name")
    ResponseEntity<List<Department>> getDepartmentByName(@RequestParam("name") String name);


    @GetMapping("/part_of_name")
    ResponseEntity<List<Department>> getDepartmentByContaining(@RequestParam ("partOfName") String partOfName);

    @GetMapping("/another_name")
    ResponseEntity<List<Department>> getDepartmentByNameNotLike(@RequestParam ("anotherName") String anotherName);


    @GetMapping("/uppercase_name")
    ResponseEntity<List<Department>> getDepartmentByNameIgnoreCase (@RequestParam("upperCaseName") String upperCaseName);
}
