package com.example.demo.rest;

import com.example.demo.entity.Project;
import com.example.demo.entity.Relatives;
import com.example.demo.service.dto.ProjectDTO;
import com.example.demo.service.dto.RelativesDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping(value= "/api/relatives")
public interface RelativesAPI {
    @GetMapping
    ResponseEntity <List<Relatives>> getAllRelative ();
    @GetMapping(value = "/{relativeId}")
    ResponseEntity <Optional<Relatives>> getRelativesById (@PathVariable ("relativeId") Long relativeId);

    @PostMapping("/{employeeID}")
    ResponseEntity <Relatives> createRelative (@PathVariable ("employeeID") Long employeeID,
                                               @RequestBody RelativesDTO relativesDTO);

    @PutMapping("/{relativeID}")
    ResponseEntity <Relatives> updateRelative (@PathVariable ("relativeID") Long relativeID,
                                               @RequestBody RelativesDTO relativesDTO);

    @DeleteMapping("/{relativeID}")
    ResponseEntity <Relatives> deleteRelative (@PathVariable ("relativeID") Long relativeID);

    @GetMapping(value = "/phone_number")
    ResponseEntity <List<Relatives>> getRelativeByPhoneNumber (@RequestParam ("phoneNumber") String phoneNumber);


}
