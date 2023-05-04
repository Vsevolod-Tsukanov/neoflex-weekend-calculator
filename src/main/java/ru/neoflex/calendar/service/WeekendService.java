package ru.neoflex.calendar.service;

import ru.neoflex.calendar.dto.WeekendDaysRequest;

import java.math.BigDecimal;

public interface WeekendService {

    BigDecimal calculate(Integer daysOfWeekend, BigDecimal yearSalary);

    BigDecimal calculateForSelectedDays(WeekendDaysRequest request);
}
