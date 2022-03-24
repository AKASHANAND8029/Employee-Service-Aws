package com.example.demo.controller;

import com.example.demo.UIModel.RequestModel;
import com.example.demo.UIModel.ResponseModel;
import com.example.demo.dto.EmployeeDto;
import com.example.demo.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class EmployeeController {
    private final EmployeeService employeeService;
    private final ModelMapper modelMapper;

    @Autowired
    public EmployeeController(EmployeeService employeeService, ModelMapper modelMapper) {
        this.employeeService = employeeService;
        this.modelMapper = modelMapper;

    }
    @Operation(summary = "employee api create a new employee")
    @ApiResponse(responseCode = "201",description = "created successfully")
    @PostMapping("/")
    public ResponseEntity<ResponseModel> createEmployee(@RequestBody RequestModel requestModel) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        EmployeeDto employeeDto = modelMapper.map(requestModel, EmployeeDto.class);
        employeeDto.setEmployeeUniqueId(UUID.randomUUID().toString());
        employeeDto = employeeService.createEmployee(employeeDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(modelMapper.map(employeeDto,ResponseModel.class));
    }
    @Operation(summary = "employee api get list of employees")
    @ApiResponse(responseCode = "201",description = "fetched successfully")
    @GetMapping("/employees")
    public ResponseEntity<List<ResponseModel>> getEmployees()
    {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        List<ResponseModel> list=new ArrayList<>();
        List<EmployeeDto> dtos=employeeService.getEmployees();
        for (EmployeeDto e:dtos)
        {
            list.add(modelMapper.map(e,ResponseModel.class));
        }
        return ResponseEntity.ok(list);
    }
    @Operation(summary = "employee api find employee by unique id")
    @ApiResponse(responseCode = "201",description = "found successfully")
    @GetMapping("/employeeId/{employeeUniqueId}")
    public ResponseEntity<ResponseModel> findEmployeeByEmployeeId(@PathVariable("employeeUniqueId") String employeeUniqueId)
    {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        return ResponseEntity.ok(modelMapper.map(employeeService.findEmployeeByEmployeeUniqueId(employeeUniqueId),ResponseModel.class));

    }
    @Operation(summary = "employee api delete employee by email")
    @ApiResponse(responseCode = "201",description = "deleted successfully")
    @DeleteMapping("/email/{email}")
    public String deleteEmployeeByEmail(@PathVariable("email") String email)
    {
        employeeService.deleteEmployeeByEmail(email);
        return "deletion successful";
    }
}
