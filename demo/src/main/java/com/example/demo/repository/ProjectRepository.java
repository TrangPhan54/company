package com.example.demo.repository;

import com.example.demo.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository <Project, Long> {

    List<Project> findProjectByProjectName (String projectName);

    List <Project> findProjectByProjectNameIgnoringCase (String upperCaseName);



}
