package com.mueblesstgo.correo.services;

import com.mueblesstgo.correo.entities.ExtraEntity;
import com.mueblesstgo.correo.repositories.ExtraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ExtraServices {
    @Autowired
    ExtraRepository extraRepository;
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
