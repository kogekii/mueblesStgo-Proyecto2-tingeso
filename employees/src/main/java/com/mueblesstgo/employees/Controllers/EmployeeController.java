package com.mueblesstgo.employees.Controllers;

import com.mueblesstgo.employees.Entitys.EmployeeEntity;
import com.mueblesstgo.employees.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @GetMapping("/getall")
    public ResponseEntity<List<EmployeeEntity>> getAllEmployees(){
        List<EmployeeEntity> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }
}
