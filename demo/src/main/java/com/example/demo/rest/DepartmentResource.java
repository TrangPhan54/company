package com.example.demo.rest;

import com.example.demo.entity.Department;
import com.example.demo.service.DepartmentService;
import com.example.demo.service.dto.DepartmentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class DepartmentResource implements DepartmentAPI {
    private final DepartmentService departmentService;
    @Override
    public ResponseEntity <List<Department>> getAllDepartment (){
        return ResponseEntity.ok(departmentService.getAllDepartment());
    }
    @Override
    public ResponseEntity<Optional<Department>> getDepartmentById (Long departmentId){
        return ResponseEntity.ok(departmentService.getDepartmentByID(departmentId));
    }
    @Override
    public ResponseEntity <Department> createDepartment (DepartmentDTO departmentDTO){
        Department department = departmentService.createDepartment(departmentDTO);
        return ResponseEntity.created(URI.create("/api/departments/"+department.getDepartmentID())).body(department);
    }

    @Override
    public ResponseEntity<Department> updateDepartment(Long departmentId, DepartmentDTO departmentDTO) {
        Department department = departmentService.updateDepartment( departmentId, departmentDTO);
        return ResponseEntity.created(URI.create("/api/departments/"+department.getDepartmentID())).body(department);
    }

    @Override
    public ResponseEntity<Department> deleteDepartmentById(Long departmentId) {
        departmentService.deleteDepartmentById(departmentId);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<List<Department>> getDepartmentByDate(LocalDate startDate) {
        return ResponseEntity.ok(departmentService.getDepartmentByDate(startDate));
    }

    @Override
    public ResponseEntity<List<Department>> getDepartmentByName(String name) {
        return ResponseEntity.ok(departmentService.getDepartmentByName(name));
    }

    @Override
    public ResponseEntity<List<Department>> getDepartmentByContaining(String partOfName) {
        return ResponseEntity.ok(departmentService.getDepartmentByNameContaining(partOfName));
    }

    @Override
    public ResponseEntity<List<Department>> getDepartmentByNameNotLike(String anotherName) {
        return ResponseEntity.ok(departmentService.getDepartmentByNameNotLike(anotherName));
    }

    @Override
    public ResponseEntity <List<Department>> getDepartmentByNameIgnoreCase (String upperCaseName){
        return ResponseEntity.ok(departmentService.getDepartmentByNameIgnoreCase(upperCaseName));
    }


}
