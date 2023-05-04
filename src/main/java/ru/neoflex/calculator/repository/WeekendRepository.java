package ru.neoflex.calculator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.neoflex.calculator.model.Weekend;

public interface WeekendRepository extends JpaRepository<Weekend, Long> {

}
