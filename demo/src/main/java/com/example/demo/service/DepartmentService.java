package com.example.demo.service;

import com.example.demo.service.dto.DepartmentDTO;
import com.example.demo.entity.Department;
import com.example.demo.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    public List<Department> getAllDepartment (){
        return departmentRepository.findAll();
    }

    public Optional <Department> getDepartmentByID (Long deptID){
        return  departmentRepository.findById(deptID);
    }
    public Department updateDepartment (Long deptID, DepartmentDTO departmentDTO){
        Department department = getDepartmentByID(deptID).get();
        department.setName(departmentDTO.getName());
        department.setStartDate(departmentDTO.getStartDate());
        return departmentRepository.save(department);
    }
    public void deleteDepartmentById (Long departmentId){
        departmentRepository.deleteById(departmentId);
    }

    public Department createDepartment (DepartmentDTO departmentDTO){
        Department department = new Department();
        department.setName(departmentDTO.getName());
        department.setStartDate(departmentDTO.getStartDate());
        return departmentRepository.save(department);
    }
    public List<Department> getDepartmentByDate(LocalDate localDate){
        return departmentRepository.findByStartDate(localDate);
    }

    public List <Department> getDepartmentByName(String name){
        return departmentRepository.findByName(name);
    }

    public List <Department> getDepartmentByNameContaining (String partOfName){
        return departmentRepository.findByNameContaining(partOfName);
    }

    public List<Department> getDepartmentByNameNotLike (String name){
        return departmentRepository.findByNameNotLike(name);
    }

    public List <Department> getDepartmentByNameIgnoreCase (String anotherName){
        return departmentRepository.findByNameIgnoreCase(anotherName);
    }



}
