package com.mueblesstgo.correo.entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "employee")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeEntity {
    @Id
    private String rutEmployee;
    @Column(name = "Name")
    private String nameEmployee;
    @Column(name = "Surname")
    private String surnameEmployee;
    @Column(name = "Category", length = 1)
    private String categoryEmployee;
    @Column(name = "birthday")
    private LocalDate birthday;
    @Column (name = "hiringdate")
    private LocalDate hiringday;
    @Column (name = "office")
    private String codOffice;
}
