package com.example.emsbackend.service.impl;

import org.springframework.stereotype.Service;

import com.example.emsbackend.dto.EmpolyeeDto;
import com.example.emsbackend.entity.Employee;
import com.example.emsbackend.exception.ResourceNotFoundException;
import com.example.emsbackend.mapper.EmployeeMapper;
import com.example.emsbackend.repository.EmployeeRepository;
import com.example.emsbackend.service.EmployeeService;
import java.util.*;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmpolyeeDto createEmployee(EmpolyeeDto empolyeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(empolyeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmpolyeeDto getEmpolyeeById(Long employeeId){
        Employee employee = employeeRepository.findById(employeeId).orElseThrow( ()-> new ResourceNotFoundException("Employee is not exists with given id: " + employeeId));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }


    public List<EmpolyeeDto> getAllEmployees(){
        List<Employee> employees  = employeeRepository.findAll();
        return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee)).collect(Collectors.toList());
    }


    public EmpolyeeDto updateEmployee(Long employeeId, EmpolyeeDto updatedEmpolyee){
           Employee employee = employeeRepository.findById(employeeId).orElseThrow(()-> new ResourceNotFoundException("Employee is not exist with given id: "+employeeId));

           employee.setFirstName(updatedEmpolyee.getFirstName());
           employee.setLastName(updatedEmpolyee.getLastName());
           employee.setEmail(updatedEmpolyee.getEmail());

           Employee updatedEmployeeObj = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
    }

    public void deleteEmployee(Long employeeId){
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(()-> new ResourceNotFoundException("Employee is not exist with given id: "+employeeId));

        employeeRepository.deleteById(employeeId);


    }

}
