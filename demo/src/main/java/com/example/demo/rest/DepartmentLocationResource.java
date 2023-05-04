package com.example.demo.rest;

import com.example.demo.entity.DepartmentLocation;
import com.example.demo.service.DepartmentLocationService;
import com.example.demo.service.dto.DepartmentLocationDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class DepartmentLocationResource implements DepartmentLocationAPI{
    private final DepartmentLocationService departmentLocationService;

    @Override
    public ResponseEntity<List<DepartmentLocation>> getAllDepartmentLocation() {
        return ResponseEntity.ok(departmentLocationService.getAllDepartmentLocation());
    }

    @Override
    public ResponseEntity<Optional<DepartmentLocation>> getDepartmentLocationById(Long locationId) {
        return ResponseEntity.ok(departmentLocationService.getDepartmentLocationById(locationId));

    }

    @Override
    public ResponseEntity<DepartmentLocation> createDepartmentLocation(Long deptID, DepartmentLocationDTO departmentLocationDTO) {
        DepartmentLocation departmentLocation = departmentLocationService.createDepartmentLocation(departmentLocationDTO,deptID);
        return ResponseEntity.created(URI.create("/api/departmentLocations"+departmentLocation.getDepartmentLocationID())).body(departmentLocation);
    }

    @Override
    public ResponseEntity<DepartmentLocation> updateDepartmentLocation(Long departmentLocationId, DepartmentLocationDTO departmentLocationDTO) {
        DepartmentLocation departmentLocation= departmentLocationService.updateDepartmentLocation(departmentLocationId,departmentLocationDTO);
        return ResponseEntity.created(URI.create("/api/departmentLocations"+departmentLocation.getDepartmentLocationID())).body(departmentLocation);
    }

    @Override
    public ResponseEntity<DepartmentLocation> deleteDepartmentLocation(Long departmentLocationId) {
        departmentLocationService.deleteDepartmentLocationById(departmentLocationId);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<List<DepartmentLocation>> getDepartmentLocationByLocationLike(String location) {
        return ResponseEntity.ok(departmentLocationService.getDepartmentLocationByLocationLike(location));
    }


}
