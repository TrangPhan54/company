package com.example.demo.rest;

import com.example.demo.entity.Assignment;
import com.example.demo.service.dto.AssignmentDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping(value ="/api/assignments")
public interface AssignmentAPI {
    @GetMapping
    ResponseEntity<List<Assignment>> getAllAssignment();
    @GetMapping(value ="/{assignmentId}")
    ResponseEntity<Optional<Assignment>> getAssignmentById (@PathVariable ("assignmentId") Long assignmentId);
    @PostMapping(value = "/{employeeId}/{projectId}")
    ResponseEntity<Assignment> createAssignment(@PathVariable ("employeeId") Long employeeId,
                                                @PathVariable ("projectId") Long projectId,
                                                @RequestBody AssignmentDTO assignmentDTO);

    @PutMapping(value ="/{assignmentId}")
    ResponseEntity<Assignment> updateAssignment(@PathVariable ("assignmentId") Long assignmentId,
                                                @RequestBody AssignmentDTO assignmentDTO);

    @DeleteMapping(value="/{assignmentId}")
    ResponseEntity<Assignment> deleteAssignment(@PathVariable("assignmentId") Long assignmentId);
}
