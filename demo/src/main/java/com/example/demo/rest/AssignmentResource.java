package com.example.demo.rest;

import com.example.demo.entity.Assignment;
import com.example.demo.service.AssignmentService;
import com.example.demo.service.dto.AssignmentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class AssignmentResource implements AssignmentAPI{
    @Autowired
    private final AssignmentService assignmentService;


    @Override
    public ResponseEntity<List<Assignment>> getAllAssignment() {
        return ResponseEntity.ok(assignmentService.getAllAssignment());
    }

    @Override
    public ResponseEntity<Optional<Assignment>> getAssignmentById(Long assignmentId) {
        return ResponseEntity.ok(assignmentService.getAssignmentById(assignmentId));
    }


    @Override
    public ResponseEntity<Assignment> createAssignment(Long employeeId, Long projectId, AssignmentDTO assignmentDTO) {
        Assignment assignment = assignmentService.createAssignment(assignmentDTO,employeeId,projectId);
        return ResponseEntity.created(URI.create("/api/assignments"+assignment.getAssignmentID())).body(assignment);

    }

    @Override
    public ResponseEntity<Assignment> updateAssignment(Long assignmentId, AssignmentDTO assignmentDTO) {
        Assignment assignment = assignmentService.updateAssignment(assignmentId,assignmentDTO);
        return ResponseEntity.created(URI.create("/api/assignments"+assignment.getAssignmentID())).body(assignment);
    }

    @Override
    public ResponseEntity<Assignment> deleteAssignment(Long assignmentId) {
        assignmentService.deleteAssignmentById(assignmentId);
        return ResponseEntity.noContent().build();
    }
}
