package com.mueblesstgo.calendar.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Calendar")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CalendarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idCalendar;
    @Column(name = "Asistencia")
    private int asistenciaDay;
    @Column(name = "Inasistencia")
    private int inasistenciaDay;
    @Column(name = "Rut")
    private String rutEmployee;
    @Column(name = "Extras")
    private int extras;
    @Column(name = "atrazo_10min")
    private int late_10;
    @Column(name = "atrazo_25min")
    private int late_25;
    @Column(name = "atrazo_45min")
    private int late_45;
}
