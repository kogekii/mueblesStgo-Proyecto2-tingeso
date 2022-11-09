package com.mueblesstgo.calendar.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JustifyModel {
    private int idJustify;
    private String rutEmployee;
    private LocalDate justifyDay;
    private String codOffice;
}
