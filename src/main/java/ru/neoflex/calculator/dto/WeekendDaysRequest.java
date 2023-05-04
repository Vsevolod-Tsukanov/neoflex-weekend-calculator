package ru.neoflex.calculator.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeekendDaysRequest {

    @NotNull
    private List<LocalDate> days;

    @NotNull
    @Positive
    private BigDecimal yearSalary;
}
