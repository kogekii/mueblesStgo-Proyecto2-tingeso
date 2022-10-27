package com.mueblesstgo.correo.services;

import com.mueblesstgo.correo.entities.EmployeeEntity;
import com.mueblesstgo.correo.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServices {
    @Autowired
    EmployeeRepository employeeRepository;
    public void newEmployee(EmployeeEntity employee){
        employeeRepository.save(employee);
    }

    public List<EmployeeEntity> getAllEmployees(){
        return employeeRepository.findAll();
    }
}
