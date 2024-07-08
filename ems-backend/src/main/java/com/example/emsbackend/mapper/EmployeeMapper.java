package com.example.emsbackend.mapper;

import com.example.emsbackend.dto.EmpolyeeDto;
import com.example.emsbackend.entity.Employee;

public class EmployeeMapper {
    
    public static EmpolyeeDto mapToEmployeeDto(Employee employee){
        return new EmpolyeeDto(
            employee.getId(),
            employee.getFirstName(),
            employee.getLastName(),
            employee.getEmail()
        );
    }

    public static Employee mapToEmployee(EmpolyeeDto empolyeeDto){
        return new Employee(
            empolyeeDto.getId(),
            empolyeeDto.getFirstName(),
            empolyeeDto.getLastName(),
            empolyeeDto.getEmail()
        );
    }
}
