package com.example.demo;

import com.example.demo.entity.Employee;
import com.example.demo.repo.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class EmployeeServiceAwsApplication  implements CommandLineRunner {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceAwsApplication(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    public static void main(String[] args) {
        SpringApplication.run(EmployeeServiceAwsApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper()
    {
        return new ModelMapper();
    }

    @Override
    public void run(String... args) throws Exception {
       employeeRepository.save(new Employee(1001, UUID.randomUUID().toString(),"Akash","Anand","akashanand8029@gmail.com"));
    }
}
