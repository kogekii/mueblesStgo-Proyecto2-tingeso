package com.mueblesstgo.employees.Services;

import com.mueblesstgo.employees.Entitys.EmployeeEntity;
import com.mueblesstgo.employees.Repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class EmployeeService {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    @Autowired
    EmployeeRepository employeeRepository;
    public void readMail(MultipartFile file){
        String[] mail;
        try{
            BufferedReader bf = new BufferedReader(new InputStreamReader(file.getInputStream()));
            String line;
            while ((line = bf.readLine()) != null) {
                mail = line.split(";");
                manageNewEmployee(mail);
            }
        }catch (Exception e){System.err.println("archivo no encontrado");}
    }
    private void manageNewEmployee(String[] mail){
        EmployeeEntity newemployee = new EmployeeEntity();
        newemployee.setRutEmployee(mail[1]);
        newemployee.setNameEmployee(mail[2]);
        newemployee.setSurnameEmployee(mail[3]);
        newemployee.setCategoryEmployee(mail[4]);
        newemployee.setBirthday(LocalDate.parse(mail[5], formatter));
        newemployee.setHiringday(LocalDate.parse(mail[6], formatter));
        newemployee.setCodOffice(mail[7]);
        newEmployee(newemployee);
    }
    public void newEmployee(EmployeeEntity employee){
        employeeRepository.save(employee);
    }

    public List<EmployeeEntity> getAllEmployees(){
        return employeeRepository.findAll();
    }

}
