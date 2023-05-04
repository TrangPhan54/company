package com.example.demo.service;

import com.example.demo.entity.Department;
import com.example.demo.entity.DepartmentLocation;
import com.example.demo.repository.DepartmentLocationRepository;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.service.dto.DepartmentDTO;
import com.example.demo.service.dto.DepartmentLocationDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartmentLocationService {
    private final DepartmentLocationRepository departmentLocationRepository;
    private final DepartmentRepository departmentRepository;

    public List<DepartmentLocation> getAllDepartmentLocation() {
        return departmentLocationRepository.findAll();
    }

    public Optional<DepartmentLocation> getDepartmentLocationById(Long departmentLocationId) {
        return departmentLocationRepository.findById(departmentLocationId);
    }

    public DepartmentLocation createDepartmentLocation(DepartmentLocationDTO departmentLocationDTO, Long deptID) {
        Optional<Department> department = departmentRepository.findById(deptID);
        DepartmentLocation departmentLocation = new DepartmentLocation();
        departmentLocation.setLocation(departmentLocationDTO.getLocation());
        if (department.isPresent()) {
            departmentLocation.setDepartment(department.get());
        }
        return departmentLocationRepository.save(departmentLocation);


    }
    public DepartmentLocation updateDepartmentLocation (Long deptID,DepartmentLocationDTO departmentLocationDTO){
        DepartmentLocation departmentLocation = getDepartmentLocationById(deptID).get();
        departmentLocation.setLocation(departmentLocationDTO.getLocation());
        return departmentLocationRepository.save(departmentLocation);
    }
    public void deleteDepartmentLocationById (Long departmentLocationId){
        departmentLocationRepository.deleteById(departmentLocationId);
    }
    public List <DepartmentLocation> getDepartmentLocationByLocationLike (String location){
        return departmentLocationRepository.findDepartmentLocationByLocationLike("%"+location+"%");
    }


}
