package com.mueblesstgo.calendar.Repository;

import com.mueblesstgo.calendar.Entity.CalendarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalendarRepository extends JpaRepository<CalendarEntity, Integer> {
}
