package com.mueblesstgo.correo.controller;

import com.mueblesstgo.correo.entities.EmployeeEntity;
import com.mueblesstgo.correo.services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/employee")
@CrossOrigin("*")
public class EmployeeController {
    @Autowired
    EmployeeServices employeeServices;
    @GetMapping("/getall")
//    @RolesAllowed("employee")
    public ResponseEntity<List<EmployeeEntity>> getAllEmployees(){
        List<EmployeeEntity> employees = employeeServices.getAllEmployees();
        return ResponseEntity.ok(employees);
    }
}
