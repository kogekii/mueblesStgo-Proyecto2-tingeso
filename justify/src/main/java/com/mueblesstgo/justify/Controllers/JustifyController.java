package com.mueblesstgo.justify.Controllers;

import com.mueblesstgo.justify.Entitys.JustifyEntity;
import com.mueblesstgo.justify.Services.JustifyServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/justify")
public class JustifyController {
    @Autowired
    JustifyServices justifyServices;
    @GetMapping("/findjustify/{rut}/{day}")
    public ResponseEntity<JustifyEntity> findJustify(@PathVariable("rut") String rut, @PathVariable("day") String date){
        LocalDate day = LocalDate.parse(date);
        JustifyEntity justify = justifyServices.findJustify(rut, day);
        return ResponseEntity.ok(justify);
    }
    @GetMapping("/getall")
    public ResponseEntity<List<JustifyEntity>> getAll(){
        List<JustifyEntity> justify= justifyServices.getAll();
        return ResponseEntity.ok(justify);
    }
}
