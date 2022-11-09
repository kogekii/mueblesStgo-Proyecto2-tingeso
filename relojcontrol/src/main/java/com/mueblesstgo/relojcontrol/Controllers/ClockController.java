package com.mueblesstgo.relojcontrol.Controllers;

import com.mueblesstgo.relojcontrol.Entity.InTimeStampEntity;
import com.mueblesstgo.relojcontrol.Entity.OutTimeStampEntity;
import com.mueblesstgo.relojcontrol.Services.ClockServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/clock")
@CrossOrigin("*")
public class ClockController {
    @Autowired
    ClockServices clockServices;
    @GetMapping("/home")
    public String temp(Model model) {
        model.addAttribute("attr", "attr");
        return "index";
    }
    @PostMapping("/readclock")
    public String leerCorreo(@RequestParam("file") MultipartFile file){
        clockServices.deleteAll();
        clockServices.readMail(file);
        return "redirect:/clock";
    }
    @GetMapping("/getallintimes")
    public ResponseEntity<List<InTimeStampEntity>> getAllInTimes(){
        List<InTimeStampEntity> intimes = clockServices.getAllInTimes();
        return ResponseEntity.ok(intimes);
    }
    @GetMapping("/getallouttimes")
    public ResponseEntity<List<OutTimeStampEntity>> getAllOutTimes(){
        List<OutTimeStampEntity> outtimes = clockServices.getAllOutTimes();
        return ResponseEntity.ok(outtimes);
    }
}
