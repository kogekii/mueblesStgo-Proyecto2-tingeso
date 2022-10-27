package com.mueblesstgo.relojcontrol.Repository;

import com.mueblesstgo.relojcontrol.Entity.OutTimeStampEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OutTimeStampRepository extends JpaRepository<OutTimeStampEntity, Integer> {
}
