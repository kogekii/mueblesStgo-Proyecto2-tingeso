package com.mueblesstgo.extra.Services;

import com.mueblesstgo.extra.Entitys.ExtraEntity;
import com.mueblesstgo.extra.Repositories.ExtraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ExtraServices {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    @Autowired
    ExtraRepository extraRepository;
    public void readMail(MultipartFile file){
        String[] mail;
        try{
            BufferedReader bf = new BufferedReader(new InputStreamReader(file.getInputStream()));
            String line;
            while ((line = bf.readLine()) != null) {
                mail = line.split(";");
                manageNewExtra(mail);
            }
        }catch (Exception e){System.err.println("archivo no encontrado");}
    }
    private void manageNewExtra(String[] mail){
        ExtraEntity newextra = new ExtraEntity();
        newextra.setRutEmployee(mail[1]);
        newextra.setExtraDay(LocalDate.parse(mail[2], formatter));
        newextra.setCodOffice(mail[3]);
        newExtra(newextra);
    }
    public void newExtra(ExtraEntity extra){
        extraRepository.save(extra);
    }

    public List<ExtraEntity> getAll(){
        return extraRepository.findAll();
    }

    public ExtraEntity findExtra(String rut, LocalDate day){
        return extraRepository.findByRutEmployeeAndExtraDay(rut, day);
    }
}
