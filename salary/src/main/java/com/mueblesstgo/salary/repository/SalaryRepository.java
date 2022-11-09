package com.mueblesstgo.salary.repository;

import com.mueblesstgo.salary.entity.SalaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaryRepository extends JpaRepository<SalaryEntity, Integer> {
    public SalaryEntity findByRutEmployee(String rut);
}
