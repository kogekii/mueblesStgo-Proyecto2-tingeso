package com.mueblesstgo.salary.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Salario")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalaryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idSalary;
    @Column(name = "Rut")
    private String rutEmployee;
    @Column(name = "Name")
    private String nameEmployee;
    @Column(name = "Surname")
    private String surnameEmployee;
    @Column(name = "Category")
    private String category;
    @Column(name = "Hiring")
    private LocalDate hiringDay;
    @Column(name = "Extra")
    private int extra;
    @Column(name = "DescuentoAtrazo")
    private int late;
    @Column(name = "DescuentoInacistencia")
    private int inasistence;
    @Column(name = "bonoAntiguedad")
    private int bonoAntiguedad;
    @Column(name = "BaseSalary")
    private int baseSalary;
    @Column(name = "FinalSalary")
    private int finalSalary;
}
