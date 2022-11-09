package com.mueblesstgo.justify.Services;

import com.mueblesstgo.justify.Entitys.JustifyEntity;
import com.mueblesstgo.justify.Repositories.JustifyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class JustifyServices {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    @Autowired
    JustifyRepository justifyRepository;
    public void readMail(MultipartFile file){
        String[] mail;
        try{
            BufferedReader bf = new BufferedReader(new InputStreamReader(file.getInputStream()));
            String line;
            while ((line = bf.readLine()) != null) {
                mail = line.split(";");
                manageNewJustify(mail);
            }
        }catch (Exception e){System.err.println("archivo no encontrado");}
    }
    private void manageNewJustify(String[] mail){
        JustifyEntity newjustify = new JustifyEntity();
        newjustify.setRutEmployee(mail[1]);
        newjustify.setJustifyDay(LocalDate.parse(mail[2], formatter));
        newjustify.setCodOffice(mail[3]);
        newJustify(newjustify);
    }

    public void newJustify(JustifyEntity justify){
        justifyRepository.save(justify);
    }
    public JustifyEntity findJustify(String rut, LocalDate date){
        return justifyRepository.findByRutEmployeeAndAndJustifyDay(rut, date);
    }

    public List<JustifyEntity> getAll(){
        return justifyRepository.findAll();
    }
}
