package com.mueblesstgo.justify.Repositories;

import com.mueblesstgo.justify.Entitys.JustifyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface JustifyRepository extends JpaRepository<JustifyEntity, Integer> {
    public JustifyEntity findByRutEmployeeAndAndJustifyDay(String rut, LocalDate date);
    public List<JustifyEntity> findByRutEmployee(String rut);
}
