package com.mueblesstgo.calendar.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TimeStampModel {
    private int id;
    private String rutEmployee;
    private LocalDate day;
    private LocalTime time;
    private int extra;
    private int late;
}
