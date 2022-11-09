package com.mueblesstgo.correo.services;

import com.mueblesstgo.correo.entities.JustifyEntity;
import com.mueblesstgo.correo.repositories.JustifyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class JustifyServices {
    @Autowired
    JustifyRepository justifyRepository;

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
