package com.mueblesstgo.relojcontrol.Services;

import com.mueblesstgo.relojcontrol.Entity.InTimeStampEntity;
import com.mueblesstgo.relojcontrol.Entity.OutTimeStampEntity;
import com.mueblesstgo.relojcontrol.Repository.InTimeStampRepository;
import com.mueblesstgo.relojcontrol.Repository.OutTimeStampRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ClockServices {
    LocalTime out = LocalTime.of(18,0,0);
    LocalTime in = LocalTime.of(8,0,0);
    @Autowired
    InTimeStampRepository inTimeStampRepository;
    @Autowired
    OutTimeStampRepository outTimeStampRepository;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    public void readMail(MultipartFile file){
        String[] timestamp;
        try{
            BufferedReader bf = new BufferedReader(new InputStreamReader(file.getInputStream()));
            String line;
            while ((line = bf.readLine()) != null) {
                timestamp = line.split(";");
                manageTimeStamp(timestamp);
            }
        }catch (Exception e){System.err.println("archivo no encontrado");}
    }

    public void manageTimeStamp(String[] timestamp){
        LocalDate date = LocalDate.parse(timestamp[0], formatter);
        if(findInTime(timestamp[2], date) == null){
            newInTime(timestamp);
        }else{
            newOutTime(timestamp);
        }
    }

    private void newInTime(String[] timestamp){
        InTimeStampEntity intime = new InTimeStampEntity();
        intime.setRutEmployee(timestamp[2]);
        intime.setDay(LocalDate.parse(timestamp[0], formatter));
        intime.setTime(LocalTime.parse(timestamp[1]));
        intime.setLate(calcularAtrazo(intime.getTime()));
        inTimeStampRepository.save(intime);
    }
    private void newOutTime(String[] timestamp){
        OutTimeStampEntity outtime = new OutTimeStampEntity();
        outtime.setRutEmployee(timestamp[2]);
        outtime.setDay(LocalDate.parse(timestamp[0], formatter));
        outtime.setTime(LocalTime.parse(timestamp[1]));
        outtime.setExtra(calcularExtra(outtime.getTime()));
        outTimeStampRepository.save(outtime);
    }

    private InTimeStampEntity findInTime(String rut, LocalDate day){
        return inTimeStampRepository.findByRutEmployeeAndAndDay(rut, day);
    }

    public List<InTimeStampEntity> getAllInTimes(){
        return inTimeStampRepository.findAll();
    }
    public List<OutTimeStampEntity> getAllOutTimes(){
        return outTimeStampRepository.findAll();
    }

    public int calcularExtra(LocalTime time){
        int extrahours = time.getHour() - out.getHour();
        return Math.max(extrahours, 0);
    }

    public int calcularAtrazo(LocalTime time){
        int lateminutes = (time.getHour() - in.getHour())*60 + time.getMinute() - in.getMinute();
        return Math.max(lateminutes, 0);
    }
    public void deleteAll(){
        inTimeStampRepository.deleteAll();
        outTimeStampRepository.deleteAll();
    }
}
