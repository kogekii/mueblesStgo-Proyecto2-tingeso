package com.mueblesstgo.salary.controller;

import com.mueblesstgo.salary.entity.SalaryEntity;
import com.mueblesstgo.salary.service.SalaryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/salary")
@CrossOrigin("*")
public class SalaryController {
    @Autowired
    SalaryServices salaryServices;
    @GetMapping("/calculatesalary")
    public void calculate(){
        salaryServices.deleteAll();
        salaryServices.importEmployees();
        salaryServices.analizeClock();
    }

    @GetMapping("/getall")
    public ResponseEntity<List<SalaryEntity>> getAll(){
        List<SalaryEntity> salary = salaryServices.getAll();
        return ResponseEntity.ok(salary);
    }
}
