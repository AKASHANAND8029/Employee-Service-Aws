package com.example.demo.service;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService {
    public EmployeeDto createEmployee(EmployeeDto employeeDto);
    public EmployeeDto findEmployeeByEmployeeUniqueId(String employeeUniqueId);
    public void deleteEmployeeByEmail(String email);
    public List<EmployeeDto> getEmployees();

}
