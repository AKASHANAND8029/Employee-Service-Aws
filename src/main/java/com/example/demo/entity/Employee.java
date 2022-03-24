package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "employee_data")
public class Employee {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column(name = "emp_id")
    private Integer employeeId;
    @Column(name = "emp_unique_id")
    private String employeeUniqueId;
    @Column(name = "emp_first_name")
    private String employeeFirstName;
    @Column(name = "emp_last_name")
    private String employeeLastName;
    @Column(name = "email")
    private String email;

}
