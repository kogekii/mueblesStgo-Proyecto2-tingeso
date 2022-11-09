package com.mueblesstgo.correo.controller;

import com.mueblesstgo.correo.entities.ExtraEntity;
import com.mueblesstgo.correo.services.ExtraServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/extra")
public class extraController {
    @Autowired
    ExtraServices extraServices;
    @GetMapping("/getall")
    public ResponseEntity<List<ExtraEntity>> getAllExtras(){
        List<ExtraEntity> extras = extraServices.getAll();
        return ResponseEntity.ok(extras);
    }
    @GetMapping("/findextra/{rut}/{day}")
    public ResponseEntity<ExtraEntity> findExtra(@PathVariable("rut") String rut, @PathVariable("day") String date){
        LocalDate day = LocalDate.parse(date);
        ExtraEntity extra = extraServices.findExtra(rut, day);
        return ResponseEntity.ok(extra);
    }
}
