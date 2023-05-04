package com.example.demo.service;

import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import com.example.demo.entity.Project;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.ProjectRepository;
import com.example.demo.service.dto.EmployeeDTO;
import com.example.demo.service.dto.ProjectDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final DepartmentRepository departmentRepository;
    public List<Project> getAllProjects (){
        return projectRepository.findAll();
    }

    public Optional <Project> getProjectById (Long projectID){
        return projectRepository.findById(projectID);
    }


    public Project createProject( Long deptID,ProjectDTO projectDTO){
        Optional<Department> department = departmentRepository.findById(deptID);
        Project project = new Project();
        project.setProjectName(projectDTO.getProjectName());
        project.setArea(projectDTO.getArea());
        if (department.isPresent())
            project.setDepartment(department.get());
        return projectRepository.save(project);
    }
    public Project updateProject (Long projectID,ProjectDTO projectDTO){
        Project project = getProjectById(projectID).get();
        project.setProjectName(projectDTO.getProjectName());
        project.setArea(projectDTO.getArea());
        return projectRepository.save(project);
    }
    public void deleteProjectById (Long projectId){
        projectRepository.deleteById(projectId);
    }

    public List <Project> getProjectByProjectName (String projectName){
        return projectRepository.findProjectByProjectName(projectName);
    }


    public List <Project> getProjectByNameIgnoreCase (String upperCaseName){
        return projectRepository.findProjectByProjectNameIgnoringCase(upperCaseName);
    }



}
