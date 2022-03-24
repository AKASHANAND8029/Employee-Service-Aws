package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class EmployeeDto {
    private String employeeUniqueId;
    private String employeeFirstName;
    private String employeeLastName;
    private String email;
}
