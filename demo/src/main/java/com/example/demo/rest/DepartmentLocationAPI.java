package com.example.demo.rest;

import com.example.demo.entity.DepartmentLocation;
import com.example.demo.service.dto.DepartmentDTO;
import com.example.demo.service.dto.DepartmentLocationDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RequestMapping(value= "/api/departmentLocations")
public interface DepartmentLocationAPI {
    @GetMapping
    ResponseEntity<List<DepartmentLocation>> getAllDepartmentLocation();

    @GetMapping(value = "/{locationId}")
    ResponseEntity<Optional<DepartmentLocation>> getDepartmentLocationById (@PathVariable ("locationId") Long locationId);

    @PostMapping(value = "/{deptID}")
    ResponseEntity<DepartmentLocation> createDepartmentLocation (@PathVariable ("deptID") Long deptID,
                                                                 @RequestBody DepartmentLocationDTO departmentLocationDTO);

    @PutMapping(value = "/{departmentLocationId}")
    ResponseEntity<DepartmentLocation> updateDepartmentLocation(@PathVariable("departmentLocationId") Long departmentLocationId,
                                                                @RequestBody DepartmentLocationDTO departmentLocationDTO);

    @DeleteMapping(value = "/{departmentLocationId}")
    ResponseEntity<DepartmentLocation> deleteDepartmentLocation(@PathVariable ("departmentLocationId") Long departmentLocationId);

    @GetMapping(value = "/location_like")
    ResponseEntity<List<DepartmentLocation>> getDepartmentLocationByLocationLike (@RequestParam ("location") String location);


}
