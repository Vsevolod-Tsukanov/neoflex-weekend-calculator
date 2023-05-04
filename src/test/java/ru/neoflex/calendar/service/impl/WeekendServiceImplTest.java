package ru.neoflex.calendar.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.neoflex.calendar.dto.WeekendDaysRequest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class WeekendServiceImplTest {

    @Autowired
    private WeekendServiceImpl weekendServiceImpl;


    @Test
    void shouldCalculateSalaryForWeekends() {
        Integer daysOfWeekend = 10;
        BigDecimal yearSalary = BigDecimal.valueOf(100000);
        BigDecimal result = weekendServiceImpl.calculate(daysOfWeekend, yearSalary);

        assertEquals(BigDecimal.valueOf(2740), result);
    }

    @Test
    void shouldCalculateSalaryForSelectedWeekends() {

        List<LocalDate> list = new ArrayList<>();
        list.add(LocalDate.parse("2023-01-01"));
        list.add(LocalDate.parse("2023-02-21"));
        list.add(LocalDate.parse("2023-02-22"));
        list.add(LocalDate.parse("2023-07-07"));
        list.add(LocalDate.parse("2023-01-17"));
        WeekendDaysRequest request = new WeekendDaysRequest(list, BigDecimal.valueOf(100000));

        BigDecimal result = weekendServiceImpl.calculateForSelectedDays(request);

        assertEquals(BigDecimal.valueOf(4932), result);
    }
}