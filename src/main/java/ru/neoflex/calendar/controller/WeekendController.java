package ru.neoflex.calendar.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.neoflex.calendar.dto.WeekendDaysRequest;
import ru.neoflex.calendar.service.WeekendService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Validated
@RequiredArgsConstructor
@RequestMapping("/weekend")
@RestController
public class WeekendController {

    private final WeekendService weekendService;

    @GetMapping("/calculate")
    public BigDecimal calculate(@RequestParam @NotNull @Positive Integer daysOfWeekend,
                                @RequestParam @NotNull @Positive BigDecimal yearSalary) {
        return weekendService.calculate(daysOfWeekend, yearSalary);
    }

    @PostMapping("/calculate/days")
    public BigDecimal calculateForDays(@Valid @RequestBody WeekendDaysRequest request) {
        return weekendService.calculateForSelectedDays(request);
    }

}
