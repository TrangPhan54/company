package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.entity.Project;
import com.example.demo.entity.Relatives;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.RelativesRepository;
import com.example.demo.service.dto.ProjectDTO;
import com.example.demo.service.dto.RelativesDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RelativesService {
    private final RelativesRepository relativesRepository;
    private final EmployeeRepository employeeRepository;

    public List<Relatives> getAllRelatives (){
        return relativesRepository.findAll();
    }

    public Optional <Relatives> getRelativesById (Long relativeID){
        return relativesRepository.findById(relativeID);
    }
    public Relatives createRelatives(Long employID,RelativesDTO relativesDTO){
        Optional<Employee> employee = employeeRepository.findById(employID);
        Relatives relatives = new Relatives();
        relatives.setFullName(relativesDTO.getFullName());
        relatives.setGender(relativesDTO.getGender());
        relatives.setPhoneNumber(relativesDTO.getPhoneNumber());
        relatives.setRelationship(relativesDTO.getRelationship());
        if (employee.isPresent())
            relatives.setEmployee(employee.get());
        return relativesRepository.save(relatives);
    }
    public Relatives updateRelative (Long relativeID, RelativesDTO relativesDTO){
        Relatives relatives = getRelativesById(relativeID).get();
        relatives.setGender(relativesDTO.getGender());
        relatives.setRelationship(relativesDTO.getRelationship());
        relatives.setFullName(relativesDTO.getFullName());
        relatives.setPhoneNumber(relativesDTO.getPhoneNumber());
        return relativesRepository.save(relatives);
    }
    public void deleteRelativeById (Long relativeID){
        relativesRepository.deleteById(relativeID);

    }
    public List <Relatives> getRelativeByPhoneNumber (String phoneNumber){
        return relativesRepository.findRelativeByPhoneNumber(phoneNumber);
    }
}
