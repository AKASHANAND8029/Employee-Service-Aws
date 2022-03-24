package com.example.demo.UIModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ResponseModel {
    private String employeeUniqueId;
    private String employeeFirstName;
    private String employeeLastName;
    private String email;
}
