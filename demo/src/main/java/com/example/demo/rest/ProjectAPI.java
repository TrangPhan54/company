package com.example.demo.rest;

import com.example.demo.entity.Employee;
import com.example.demo.entity.Project;
import com.example.demo.service.dto.EmployeeDTO;
import com.example.demo.service.dto.ProjectDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RequestMapping(value ="/api/projects")
public interface ProjectAPI {
    @GetMapping
    ResponseEntity<List<Project>> getAllProject ();

    @GetMapping(value = "/{projectId}")
    ResponseEntity<Optional<Project>> getProjectById (@PathVariable ("projectId") Long projectID);

    @PostMapping("/{deptID}")
    ResponseEntity<Project> createProject (@PathVariable("deptID") Long deptID,
            @RequestBody ProjectDTO projectDTO);

    @PutMapping(value = "/{projectID}")
    ResponseEntity<Project> updateProject (@PathVariable ("projectID") Long projectID,
                                           @RequestBody ProjectDTO projectDTO);

    @DeleteMapping(value = "/{projectID}")
    ResponseEntity<Project> deleteProjectById (@PathVariable ("projectID") Long projectID);

    @GetMapping (value = "/project_name")
    ResponseEntity <List<Project>> getProjectByProjectName (@RequestParam ("projectName") String projectName);


    @GetMapping (value ="/uppercase_name")
    ResponseEntity <List <Project>> getProjectByNameIgnoreCase (@RequestParam ("upperCaseName") String upperCaseName);






}
