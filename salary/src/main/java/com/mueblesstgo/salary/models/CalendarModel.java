package com.mueblesstgo.salary.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CalendarModel {
    private int idCalendar;
    private int asistenciaDay;
    private int inasistenciaDay;
    private String rutEmployee;
    private int extras;
    private int late_10;
    private int late_25;
    private int late_45;
}
