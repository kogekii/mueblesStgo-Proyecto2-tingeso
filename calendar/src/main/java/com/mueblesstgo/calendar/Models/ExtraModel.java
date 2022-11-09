package com.mueblesstgo.calendar.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExtraModel {
    private int idExtra;
    private String rutEmployee;
    private LocalDate extraDay;
    private String codOffice;
}
