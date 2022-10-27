package com.mueblesstgo.correo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "justify")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JustifyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idJustify;
    @Column(name = "Rut")
    private String rutEmployee;
    @Column(name = "day")
    private LocalDate justifyDay;
    @Column (name = "office")
    private String codOffice;
}
