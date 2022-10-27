package com.mueblesstgo.calendar.Services;

import com.mueblesstgo.calendar.Entity.CalendarEntity;
import com.mueblesstgo.calendar.Models.EmployeeModel;
import com.mueblesstgo.calendar.Models.TimeStampModel;
import com.mueblesstgo.calendar.Repository.CalendarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.sql.Array;
import java.sql.Time;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class CalendarServices {
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    CalendarRepository calendarRepository;
    private void saveDay(CalendarEntity day){
        calendarRepository.save(day);
    }
    public List<TimeStampModel> getAllInTimes (){
        TimeStampModel[] times = restTemplate.getForObject("http://localhost:8002//clock/getallintimes", TimeStampModel[].class);
        return Arrays.asList(times);
    }
    public List<TimeStampModel> getAllOutTimes (){
        TimeStampModel[] times = restTemplate.getForObject("http://localhost:8002//clock/getallouttimes", TimeStampModel[].class);
        return Arrays.asList(times);
    }
    public void importEmployees(){
        EmployeeModel[] employees = restTemplate.getForObject("http://localhost:8003/employee/getall", EmployeeModel[].class);
        List<EmployeeModel> employes = Arrays.asList(employees);
        employes.forEach(t -> {
            
        });

    }
    public void analizeInTimes(){
        List<TimeStampModel> times = getAllInTimes();
        times.forEach(t->{
            CalendarEntity cal = new CalendarEntity();
            cal.setRutEmployee(t.getRutEmployee());
            saveDay(cal);
        });
    }
    public void analizeOutTimes(){
        List<TimeStampModel> times = getAllOutTimes();
        times.forEach(t->{
            CalendarEntity cal = new CalendarEntity();
            cal.setRutEmployee(t.getRutEmployee());
            saveDay(cal);
        });
    }
    public void deleteAll(){
        calendarRepository.deleteAll();
    }
}
