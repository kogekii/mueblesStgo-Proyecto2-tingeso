package com.mueblesstgo.correo.repositories;

import com.mueblesstgo.correo.entities.JustifyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface JustifyRepository extends JpaRepository<JustifyEntity, Integer> {
    public JustifyEntity findByRutEmployeeAndAndJustifyDay(String rut, LocalDate date);
    public List<JustifyEntity> findByRutEmployee(String rut);
}
