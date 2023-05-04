package com.example.demo.rest;

import com.example.demo.entity.Relatives;
import com.example.demo.service.RelativesService;
import com.example.demo.service.dto.ProjectDTO;
import com.example.demo.service.dto.RelativesDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class RelativesResource implements RelativesAPI {
    @Autowired
    private final RelativesService relativesService;

    @Override
    public ResponseEntity<List<Relatives>> getAllRelative (){
        return ResponseEntity.ok(relativesService.getAllRelatives());
    }

    @Override
    public ResponseEntity<Optional<Relatives>> getRelativesById(Long relativeId) {
        return ResponseEntity.ok(relativesService.getRelativesById(relativeId));
    }

    @Override
    public ResponseEntity<Relatives> createRelative(Long employeeID, RelativesDTO relativesDTO) {
        Relatives relatives = relativesService.createRelatives(employeeID,relativesDTO);
        return ResponseEntity.created(URI.create("/api/relatives/"+relatives.getRelativeID())).body(relatives);

    }

    @Override
    public ResponseEntity<Relatives> updateRelative(Long relativeID, RelativesDTO relativesDTO) {
        Relatives relatives = relativesService.updateRelative(relativeID,relativesDTO);
        return ResponseEntity.created(URI.create("/api/relatives/"+relatives.getRelativeID())).body(relatives);

    }


    @Override
    public ResponseEntity<Relatives> deleteRelative(Long relativeID) {
        relativesService.deleteRelativeById(relativeID);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity <List<Relatives>> getRelativeByPhoneNumber(String nameOfRelative) {
        return ResponseEntity.ok(relativesService.getRelativeByPhoneNumber(nameOfRelative));
    }


}
