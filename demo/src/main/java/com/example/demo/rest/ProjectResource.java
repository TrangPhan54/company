package com.example.demo.rest;

import com.example.demo.entity.Employee;
import com.example.demo.entity.Project;
import com.example.demo.service.ProjectService;
import com.example.demo.service.dto.EmployeeDTO;
import com.example.demo.service.dto.ProjectDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ProjectResource implements ProjectAPI {
    private final ProjectService projectService;
    @Override
    public ResponseEntity<List<Project>> getAllProject(){
        return ResponseEntity.ok(projectService.getAllProjects());
    }

    @Override
    public ResponseEntity<Optional<Project>> getProjectById(Long projectID) {
        return ResponseEntity.ok(projectService.getProjectById(projectID));
    }

    @Override
    public ResponseEntity<Project> createProject(Long deptID, ProjectDTO projectDTO) {
        Project project = projectService.createProject(deptID,projectDTO);
        return ResponseEntity.created(URI.create("/api/projects/"+project.getProjectID())).body(project);
    }

    @Override
    public ResponseEntity<Project> updateProject(Long projectID, ProjectDTO projectDTO) {
        Project project = projectService.updateProject(projectID,projectDTO);
        return ResponseEntity.created(URI.create("/api/projects/"+project.getProjectID())).body(project);
    }


    @Override
    public ResponseEntity<Project> deleteProjectById(Long projectID) {
        projectService.deleteProjectById(projectID);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<List<Project>> getProjectByProjectName(String projectName) {
        return ResponseEntity.ok(projectService.getProjectByProjectName(projectName));
    }

    @Override
    public ResponseEntity<List<Project>> getProjectByNameIgnoreCase(String upperCaseName) {
        return ResponseEntity.ok(projectService.getProjectByNameIgnoreCase(upperCaseName));
    }


}
