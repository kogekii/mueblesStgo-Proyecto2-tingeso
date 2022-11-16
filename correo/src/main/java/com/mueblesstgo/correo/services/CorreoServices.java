package com.mueblesstgo.correo.services;

import com.mueblesstgo.correo.entities.EmployeeEntity;
import com.mueblesstgo.correo.entities.ExtraEntity;
import com.mueblesstgo.correo.entities.JustifyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
@Service
public class CorreoServices {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    @Autowired
    EmployeeServices employeeServices;
    @Autowired
    JustifyServices justifyServices;
    @Autowired
    ExtraServices extraServices;
    public void readMail(MultipartFile file){
        String[] mail;
        try{
            BufferedReader bf = new BufferedReader(new InputStreamReader(file.getInputStream()));
            String line;
            while ((line = bf.readLine()) != null) {
                mail = line.split(";");
                manageMail(mail);
            }
        }catch (Exception e){System.err.println("archivo no encontrado");}
    }
    void manageMail(String[] mail){
        if (Objects.equals(mail[0], "nuevo-empleado")){
            manageNewEmployee(mail);
        } else if (Objects.equals(mail[0], "justificacion")) {
            manageNewJustify(mail);
        }else if(Objects.equals(mail[0], "hora-extra")){
            manageNewExtra(mail);
        }
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
        employeeServices.newEmployee(newemployee);
    }

    private void manageNewJustify(String[] mail){
        JustifyEntity newjustify = new JustifyEntity();
        newjustify.setRutEmployee(mail[1]);
        newjustify.setJustifyDay(LocalDate.parse(mail[2], formatter));
        newjustify.setCodOffice(mail[3]);
        justifyServices.newJustify(newjustify);
    }

    private void manageNewExtra(String[] mail){
        ExtraEntity newextra = new ExtraEntity();
        newextra.setRutEmployee(mail[1]);
        newextra.setExtraDay(LocalDate.parse(mail[2], formatter));
        newextra.setCodOffice(mail[3]);
        extraServices.newExtra(newextra);
    }


}
