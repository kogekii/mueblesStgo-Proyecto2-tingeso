package com.mueblesstgo.correo.repositories;

import com.mueblesstgo.correo.entities.ExtraEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface ExtraRepository extends JpaRepository<ExtraEntity, Integer> {
    public ExtraEntity findByRutEmployeeAndExtraDay(String rut, LocalDate day);
}
