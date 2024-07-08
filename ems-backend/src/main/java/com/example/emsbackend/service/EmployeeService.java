package com.example.emsbackend.service;

import java.util.List;

import com.example.emsbackend.dto.EmpolyeeDto;

public interface EmployeeService {
    EmpolyeeDto createEmployee(EmpolyeeDto employeeDto);

    EmpolyeeDto getEmpolyeeById(Long employeeId);

    List<EmpolyeeDto> getAllEmployees();

    EmpolyeeDto updateEmployee(Long employeeId,EmpolyeeDto updatedEmpolyee);

    void deleteEmployee(Long employeeId);
}
