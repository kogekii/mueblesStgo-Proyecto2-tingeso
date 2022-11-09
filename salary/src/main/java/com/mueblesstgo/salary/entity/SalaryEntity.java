package com.mueblesstgo.salary.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
    @Column(name = "Extra")
    private int extra;
    @Column(name = "Descuento_Atrazo")
    private int late;
    @Column(name = "Descuento_Inacistencia")
    private int inasistence;
    @Column(name = "BaseSalary")
    private int baseSalary;
}
