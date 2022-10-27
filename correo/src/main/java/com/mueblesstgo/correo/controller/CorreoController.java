package com.mueblesstgo.correo.controller;

import com.mueblesstgo.correo.entities.EmployeeEntity;
import com.mueblesstgo.correo.services.CorreoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RestController
@RequestMapping
public class CorreoController {
    @Autowired
    CorreoServices correoServices;
    @GetMapping("/correo")
    public String temp(Model model) {
        model.addAttribute("attr", "attr");
        return "index";
    }
    @PostMapping("/leercorreo")
    public String leerCorreo(@RequestParam("file") MultipartFile file){
        correoServices.readMail(file);
        return "redirect:/";
    }

}
