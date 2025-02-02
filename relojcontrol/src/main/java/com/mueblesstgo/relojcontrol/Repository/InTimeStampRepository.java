package com.mueblesstgo.relojcontrol.Repository;

import com.mueblesstgo.relojcontrol.Entity.InTimeStampEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface InTimeStampRepository extends JpaRepository<InTimeStampEntity, Integer> {
    public InTimeStampEntity findByRutEmployee(String rut);
    public InTimeStampEntity findByRutEmployeeAndAndDay(String rut, LocalDate day);
}
