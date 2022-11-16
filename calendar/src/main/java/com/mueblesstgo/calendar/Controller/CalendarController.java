package com.mueblesstgo.calendar.Controller;

import com.mueblesstgo.calendar.Entity.CalendarEntity;
import com.mueblesstgo.calendar.Services.CalServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;
import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping("/calendar")
public class CalendarController {
    @Autowired
    CalServices calServices;

    @GetMapping("/analizeclock")
    public ResponseEntity<List<CalendarEntity>> getAllInTimes(){
        calServices.deleteAll();
        calServices.importEmployees();
        calServices.analizeInTimes();
        calServices.analizeOutTimes();
        calServices.calculateInassistence();
        calServices.validateJustify();
        List<CalendarEntity> calendar = calServices.getAll();
        return ResponseEntity.ok(calendar);
    }
}
