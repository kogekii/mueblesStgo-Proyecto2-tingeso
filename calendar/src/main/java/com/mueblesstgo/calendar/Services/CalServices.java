package com.mueblesstgo.calendar.Services;

import com.mueblesstgo.calendar.Entity.CalendarEntity;
import com.mueblesstgo.calendar.Models.EmployeeModel;
import com.mueblesstgo.calendar.Models.ExtraModel;
import com.mueblesstgo.calendar.Models.JustifyModel;
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
            cal.setLate_10(0);
            cal.setLate_25(0);
            cal.setLate_45(0);
            saveDay(cal);
        });

    }

    //funcion que calculo si la fecha de entrada corresponde a un dia de semana(laboral)
    public boolean dayOfWeek(LocalDate day){
        Calendar cal = new GregorianCalendar(day.getYear(),day.getMonthValue() - 1, day.getDayOfMonth());
        int numberday = cal.get(Calendar.DAY_OF_WEEK);
        return numberday != 1 && numberday != 7;
    }
    public void analizeInTimes(){
        List<TimeStampModel> times = getAllInTimes();
        times.forEach(t->{
            System.out.println(t.getLate());
            if (dayOfWeek(t.getDay())){
                CalendarEntity employee = findByRut(t.getRutEmployee());
                if (t.getLate() >= 70){
                    employee.setInasistenciaDay(employee.getInasistenciaDay() + 1);
                }else{
                    System.out.println(t.getLate());
                    if(t.getLate() >= 10 && t.getLate() < 25){
                        employee.setLate_10(employee.getLate_10() + 1);
                    } else if (t.getLate() >= 25 && t.getLate() < 45) {
                        employee.setLate_25(employee.getLate_25() + 1);
                    } else if (t.getLate() >= 45 && t.getLate() < 70) {
                        employee.setLate_45(employee.getLate_45() + 1);
                    }
                }
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
                if (validateExtra(t.getDay(), t.getRutEmployee())){
                    employee.setExtras(employee.getExtras() + t.getExtra());
                }
                saveDay(employee);
            }
        });
    }
    public void calculateInassistence(){
        List<CalendarEntity> cal = getAll();
        List<TimeStampModel> times = getAllInTimes();
        LocalDate day = times.get(0).getDay();
        Calendar calendario = new GregorianCalendar(day.getYear(), day.getMonthValue() - 1, 1);
        int workDays = calendario.getActualMaximum(Calendar.DATE) - calcularFeriados(calendario);
        cal.forEach(c -> {
            c.setInasistenciaDay( workDays - c.getAsistenciaDay());
            saveDay(c);
        });
    }

    public void validateJustify(){
        JustifyModel[] justify = restTemplate.getForObject("http://localhost:8003/justify/getall/", JustifyModel[].class);
        List<JustifyModel> justifys = Arrays.asList(justify);
        justifys.forEach(j ->{
            CalendarEntity cal = findByRut(j.getRutEmployee());
            if (cal.getInasistenciaDay() >= 0){
                cal.setInasistenciaDay(cal.getInasistenciaDay() - 1);
                saveDay(cal);
            }
        });
    }
    public int calcularFeriados(Calendar calendario){
        int feriados = 0;
        for (int i = 1; i < calendario.getActualMaximum(Calendar.DATE); i++){
            calendario.set(calendario.get(1), calendario.get(2), i);
            if (calendario.get(Calendar.DAY_OF_WEEK) == 1 || calendario.get(Calendar.DAY_OF_WEEK) == 7){
                feriados++;
            }
        }
        return feriados;
    }
    public boolean validateExtra(LocalDate day, String rut){
        ExtraModel extra = restTemplate.getForObject("http://localhost:8003/extra/findextra/" + rut + "/" + day.toString(), ExtraModel.class);
        return extra != null;
    }
    public List<CalendarEntity> getAll(){
        return calendarRepository.findAll();
    }
    public void deleteAll(){
        calendarRepository.deleteAll();
    }

    public CalendarEntity findByRut(String rut){
        return calendarRepository.findByRutEmployee(rut);
    }
}
