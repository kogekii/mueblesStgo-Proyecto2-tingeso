package com.mueblesstgo.correo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Extras")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExtraEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idExtra;
    @Column(name = "Rut")
    private String rutEmployee;
    @Column(name = "day")
    private LocalDate extraDay;
    @Column (name = "office")
    private String codOffice;
}
