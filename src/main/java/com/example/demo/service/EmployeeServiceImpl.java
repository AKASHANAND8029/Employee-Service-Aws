package com.example.demo.service;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.Employee;
import com.example.demo.repo.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Service

public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Employee employee=modelMapper.map(employeeDto,Employee.class);
        employee.setEmployeeId(new Random().nextInt(10000));
        employee=employeeRepository.save(employee);
        return modelMapper.map(employee,EmployeeDto.class);
    }

    private Employee findEmployeeId(String employeeUniqueId) {

        Employee employee= employeeRepository.findByEmployeeUniqueId(employeeUniqueId);
        return employee;
    }

    @Override
    public EmployeeDto findEmployeeByEmployeeUniqueId(String employeeUniqueId) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Employee employee=findEmployeeId(employeeUniqueId);
        return modelMapper.map(employee,EmployeeDto.class);
    }

    private Employee findEmployeeByEmail(String email)
    {
        Employee employee=employeeRepository.findByEmail(email);
        return employee;
    }
    @Override
    public void deleteEmployeeByEmail(String email) {
        Employee employee=findEmployeeByEmail(email);
        employeeRepository.delete(employee);

    }
    @Override
    public List<EmployeeDto> getEmployees() {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        List<EmployeeDto> list=new ArrayList<>();
        Iterable<Employee> iterable= employeeRepository.findAll();

        Iterator<Employee> iterator= iterable.iterator();
        while (iterator.hasNext())
        {
            list.add(modelMapper.map(iterator.next(),EmployeeDto.class));
        }
        return list;
    }
}
