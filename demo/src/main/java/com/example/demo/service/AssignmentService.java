package com.example.demo.service;

import com.example.demo.entity.Assignment;
import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import com.example.demo.entity.Project;
import com.example.demo.repository.AssignmentRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.ProjectRepository;
import com.example.demo.service.dto.AssignmentDTO;
import com.example.demo.service.dto.ProjectDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AssignmentService {
    private final AssignmentRepository assignmentRepository;
    private final EmployeeRepository employeeRepository;
    private final ProjectRepository projectRepository;

    public List<Assignment> getAllAssignment(){
        return assignmentRepository.findAll();
    }

    public Optional <Assignment> getAssignmentById (Long assignmentId){
        return assignmentRepository.findById(assignmentId);
    }
    public Assignment createAssignment(AssignmentDTO assignmentDTO, Long employID, Long projectID){
        Optional<Employee> employee = employeeRepository.findById(employID);
        Assignment assignment = new Assignment();
        assignment.setNumberOfHour(assignmentDTO.getNumberOfHour());
        Optional<Project> project = projectRepository.findById(projectID);
        if(employee.isPresent()){
            assignment.setEmployee(employee.get());
        }
        if(project.isPresent()){
            assignment.setProject(project.get());
        }
        return assignmentRepository.save(assignment);

    }
    public Assignment updateAssignment (Long assignmentID, AssignmentDTO assignmentDTO){
        Assignment assignment = getAssignmentById(assignmentID).get();
        assignment.setNumberOfHour(assignmentDTO.getNumberOfHour());
        return assignmentRepository.save(assignment);

    }
    public void deleteAssignmentById (Long assignmentID){
        assignmentRepository.deleteById(assignmentID);
    }


}
