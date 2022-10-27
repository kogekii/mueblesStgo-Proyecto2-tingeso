package com.mueblesstgo.relojcontrol.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "outtimestamp")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OutTimeStampEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idOutTime;
    @Column(name = "rut")
    private String rutEmployee;
    @Column(name = "day")
    private LocalDate day;
    @Column(name = "time")
    private LocalTime time;
    @Column(name = "Extra")
    private int extra;
    @Column(name = "Late")
    private int late;
}
