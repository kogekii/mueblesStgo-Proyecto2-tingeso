package com.mueblesstgo.calendar.Services;

import com.mueblesstgo.calendar.Entity.CalendarEntity;
import com.mueblesstgo.calendar.Models.EmployeeModel;
import com.mueblesstgo.calendar.Models.TimeStampModel;
import com.mueblesstgo.calendar.Repository.CalendarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

@Service
public class CalServices {
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    CalendarRepository calendarRepository;
    private void saveDay(CalendarEntity day){
        calendarRepository.save(day);
    }
    public List<TimeStampModel> getAllInTimes (){
        TimeStampModel[] times = restTemplate.getForObject("http://localhost:8002/clock/getallintimes", TimeStampModel[].class);
        return Arrays.asList(times);
    }
    public List<TimeStampModel> getAllOutTimes (){
        TimeStampModel[] times = restTemplate.getForObject("http://localhost:8002/clock/getallouttimes", TimeStampModel[].class);
        return Arrays.asList(times);
    }
    
    public void importEmployees(){
        EmployeeModel[] employees = restTemplate.getForObject("http://localhost:8003/employee/getall", EmployeeModel[].class);
        List<EmployeeModel> employes = Arrays.asList(employees);
        employes.forEach(t -> {
            CalendarEntity cal = new CalendarEntity();
            cal.setRutEmployee(t.getRutEmployee());
            saveDay(cal);
        });

    }
    //funcion que calculo si la fecha de entrada corresponde a un dia de semana(laboral)
    public boolean dayOfWeek(LocalDate day){
        Calendar cal = new GregorianCalendar(day.getYear(),day.getMonthValue(), day.getDayOfMonth());
        int numberday = cal.get(Calendar.DAY_OF_WEEK);
        return numberday != 1 && numberday != 7;
    }
    public void analizeInTimes(){
        List<TimeStampModel> times = getAllInTimes();
        times.forEach(t->{
            if (dayOfWeek(t.getDay())){
                CalendarEntity employee = findByRut(t.getRutEmployee());
                employee.setExtras(employee.getExtras() + t.getExtra());
                employee.setAsistenciaDay(employee.getAsistenciaDay() + 1);
                saveDay(employee);
            }
        });
    }
    public void analizeOutTimes(){
        List<TimeStampModel> times = getAllOutTimes();
        times.forEach(t->{
            if (dayOfWeek(t.getDay())){
                CalendarEntity employee = findByRut(t.getRutEmployee());
                employee.setExtras(employee.getExtras() + t.getExtra());
                saveDay(employee);
            }
        });
    }
    public void deleteAll(){
        calendarRepository.deleteAll();
    }

    public CalendarEntity findByRut(String rut){
        return calendarRepository.findByRutEmployee(rut);
    }
}
