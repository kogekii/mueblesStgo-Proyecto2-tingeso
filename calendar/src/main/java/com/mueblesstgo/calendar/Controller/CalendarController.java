package com.mueblesstgo.calendar.Controller;

import com.mueblesstgo.calendar.Models.TimeStampModel;
import com.mueblesstgo.calendar.Services.CalendarServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;
import java.util.List;

@RestController
@RequestMapping("/calendar")
public class CalendarController {
    @Autowired
    CalendarServices calendarServices;

    @GetMapping("/times/getall")
    public void getAllInTimes(){
        calendarServices.deleteAll();
        calendarServices.analizeInTimes();
        calendarServices.analizeOutTimes();
    }
}
