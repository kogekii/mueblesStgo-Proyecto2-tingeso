package com.mueblesstgo.calendar.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeModel {
    private String rutEmployee;
    private String nameEmployee;
    private String surnameEmployee;
    private String categoryEmployee;
    private LocalDate birthday;
    private LocalDate hiringday;
    private String codOffice;
}
