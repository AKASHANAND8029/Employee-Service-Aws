package com.example.demo.repo;

import com.example.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository <Employee,Integer> {
    @Query
    public Employee findByEmail(String email);
    @Query
    public Employee findByEmployeeUniqueId(String employeeUniqueId);


}
