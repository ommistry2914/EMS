package com.example.emsbackend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.emsbackend.dto.EmpolyeeDto;
import com.example.emsbackend.service.EmployeeService;

import lombok.AllArgsConstructor;
import java.util.*;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    // Buid Add Employee Rest API
    @PostMapping
    public ResponseEntity<EmpolyeeDto> createEmployee(@RequestBody EmpolyeeDto empolyeeDto){
        EmpolyeeDto savedEmpolyee =  employeeService.createEmployee(empolyeeDto);
        return new ResponseEntity<>(savedEmpolyee,HttpStatus.CREATED);
    }

    //Build Get Employee Rest API
    @GetMapping("{id}")
    public ResponseEntity<EmpolyeeDto> getEmployeeById(@PathVariable("id") Long employeeId){
        EmpolyeeDto empolyeeDto = employeeService.getEmpolyeeById(employeeId);
        return ResponseEntity.ok(empolyeeDto);
    }

    //Buid Get All Employee Rest API
    @GetMapping
    public ResponseEntity<List<EmpolyeeDto>> getAllEmployees(){
        List<EmpolyeeDto> employees =  employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    //Build Update Employee Rest API
    @PutMapping("{id}")
    public ResponseEntity<EmpolyeeDto> updateEmployee(@PathVariable("id") Long employeeId,@RequestBody EmpolyeeDto updatedEmployee){
        EmpolyeeDto empolyeeDto = employeeService.updateEmployee(employeeId, updatedEmployee);
        return ResponseEntity.ok(empolyeeDto);
    }
    
    //Buid Delete Employee Rest API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("Employee deleted successfully !..");
    }
}
