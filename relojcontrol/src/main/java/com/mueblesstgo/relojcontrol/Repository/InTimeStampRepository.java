package com.mueblesstgo.relojcontrol.Repository;

import com.mueblesstgo.relojcontrol.Entity.InTimeStampEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InTimeStampRepository extends JpaRepository<InTimeStampEntity, Integer> {
    public InTimeStampEntity findByRutEmployee(String rut);
}
