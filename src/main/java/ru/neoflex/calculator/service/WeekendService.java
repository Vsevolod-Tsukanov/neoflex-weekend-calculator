package ru.neoflex.calculator.service;

import ru.neoflex.calculator.dto.WeekendDaysRequest;

import java.math.BigDecimal;

public interface WeekendService {

    BigDecimal calculate(Integer daysOfWeekend, BigDecimal yearSalary);

    BigDecimal calculateForSelectedDays(WeekendDaysRequest request);
}
