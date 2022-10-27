package com.mueblesstgo.correo.services;

import com.mueblesstgo.correo.entities.ExtraEntity;
import com.mueblesstgo.correo.repositories.ExtraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExtraServices {
    @Autowired
    ExtraRepository extraRepository;
    public void newExtra(ExtraEntity extra){
        extraRepository.save(extra);
    }
}
