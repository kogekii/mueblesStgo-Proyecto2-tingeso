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
    private LocalDate asistenciaDay;
    @Column(name = "Inasistencia")
    private LocalDate inasistenciaDay;
    @Column(name = "Rut")
    private String rutEmployee;
    @Column(name = "Extras")
    private int extras;
}
