package com.mueblesstgo.salary.service;

import com.mueblesstgo.salary.entity.SalaryEntity;
import com.mueblesstgo.salary.models.CalendarModel;
import com.mueblesstgo.salary.models.EmployeeModel;
import com.mueblesstgo.salary.repository.SalaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class SalaryServices {
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    SalaryRepository salaryRepository;
    public void analizeClock(){
        CalendarModel[] cal = restTemplate.getForObject("http://localhost:8001/calendar/analizeclock", CalendarModel[].class);
        List<CalendarModel> calendar = Arrays.asList(cal);
        calendar.forEach(c ->{
            SalaryEntity salary = findEmployee(c.getRutEmployee());
            salary.setExtra(extraCategory(salary.getCategory(), c.getExtras()));
            salary.setLate(calculateLate(c.getLate_10(), c.getLate_25(), c.getLate_45(), salary.getCategory()));
            salary.setInasistence(calculateinacistence(c.getAsistenciaDay(), salary.getCategory()));
            saveSalary(salary);
        });
    }

    public void saveSalary(SalaryEntity salary){
        salaryRepository.save(salary);
    }
    public void importEmployees(){
        EmployeeModel[] employees = restTemplate.getForObject("http://localhost:8003/employee/getall", EmployeeModel[].class);
        List<EmployeeModel> employes = Arrays.asList(employees);
        employes.forEach(t -> {
            SalaryEntity sueldo = new SalaryEntity();
            sueldo.setRutEmployee(t.getRutEmployee());
            sueldo.setNameEmployee(t.getNameEmployee());
            sueldo.setSurnameEmployee(t.getSurnameEmployee());
            sueldo.setCategory(t.getCategoryEmployee());
            sueldo.setBaseSalary(calculateBaseSalary(sueldo.getCategory()));
            saveSalary(sueldo);
        });
    }
    public int calculateLate(int late10, int late25, int late45, String category){
        double descont = (late10 * 0.01 + late25 * 0.03 + late45 * 0.06);
        return switch (category) {
            case ("A") -> (int)(1700000 * descont);
            case ("B") -> (int)(1200000 * descont);
            case ("C") -> (int)(800000 * descont);
            default -> 0;
        };
    }

    public int calculateinacistence(int i, String category){
        double descont =   i * 0.15;
        return switch (category) {
            case ("A") -> (int)(1700000 * descont);
            case ("B") -> (int)(1200000 * descont);
            case ("C") -> (int)(800000 * descont);
            default -> 0;
        };
    }
    public int calculateBaseSalary(String category){
        return switch (category) {
            case ("A") -> 1700000;
            case ("B") -> 1200000;
            case ("C") -> 800000;
            default -> 0;
        };
    }

    public int extraCategory(String category, int extra){
        return switch (category) {
            case ("A") -> extra*25000;
            case ("B") -> extra*20000;
            case ("C") -> extra*10000;
            default -> 0;
        };
    }
    public void deleteAll(){
        salaryRepository.deleteAll();
    }
    public List<SalaryEntity> getAll(){
        return salaryRepository.findAll();
    }

    public SalaryEntity findEmployee(String rut){
        return salaryRepository.findByRutEmployee(rut);
    }
}
