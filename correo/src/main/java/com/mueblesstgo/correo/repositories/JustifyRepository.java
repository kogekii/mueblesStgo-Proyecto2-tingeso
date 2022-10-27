package com.mueblesstgo.correo.repositories;

import com.mueblesstgo.correo.entities.JustifyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JustifyRepository extends JpaRepository<JustifyEntity, Integer> {
}
