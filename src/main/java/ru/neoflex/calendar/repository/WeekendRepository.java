package ru.neoflex.calendar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.neoflex.calendar.model.Weekend;

public interface WeekendRepository extends JpaRepository<Weekend, Long> {

}
