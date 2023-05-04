package ru.neoflex.calendar.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.neoflex.calendar.dto.WeekendDaysRequest;
import ru.neoflex.calendar.model.Weekend;
import ru.neoflex.calendar.repository.WeekendRepository;
import ru.neoflex.calendar.service.WeekendService;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class WeekendServiceImpl implements WeekendService {
    private static final BigDecimal DAYS_IN_YEAR = BigDecimal.valueOf(365);
    private final WeekendRepository weekendRepository;

    @Override
    public BigDecimal calculate(Integer daysOfWeekend, BigDecimal yearSalary) {
        BigDecimal weekend = BigDecimal.valueOf(daysOfWeekend);
        return yearSalary.divide(DAYS_IN_YEAR, RoundingMode.CEILING).multiply(weekend);
    }

    @Override
    public BigDecimal calculateForSelectedDays(WeekendDaysRequest request) {
        var allHolidays = weekendRepository.findAll(Sort.by(Sort.Direction.ASC, "date"))
                .stream().map(Weekend::getDate).collect(Collectors.toList());

        Set<LocalDate> totalWeekends = getTotalWeekends(request.getDays(), allHolidays);
        BigDecimal weekend = BigDecimal.valueOf(totalWeekends.size());

        return request.getYearSalary().divide(DAYS_IN_YEAR, RoundingMode.CEILING).multiply(weekend);
    }

    private Set<LocalDate> getTotalWeekends(List<LocalDate> request, List<LocalDate> allHolidays) {

        Set<LocalDate> result = new HashSet<>();

        for (LocalDate localDate : request) {
            iterate(localDate, allHolidays, result);
        }

        return result;
    }

    private void iterate(LocalDate inputDate, List<LocalDate> allHolidays, Set<LocalDate> setToWrite) {
        LocalDate nextDay = inputDate.plusDays(1);
        int inputIndex = allHolidays.indexOf(inputDate);

        if (inputIndex == -1) {
            setToWrite.add(inputDate);
            inputIndex = allHolidays.indexOf(nextDay);

            if (inputIndex == -1) {
                return;
            }
        }

        setToWrite.add(inputDate);

        for (int i = inputIndex; i < allHolidays.size(); i++) {
            LocalDate currentDate = allHolidays.get(i);

            if (currentDate.equals(inputDate)) {
                continue;
            }

            setToWrite.add(currentDate);
            if (i + 1 == allHolidays.size()) {
                break;
            }

            if (!currentDate.plusDays(1).equals(allHolidays.get(i + 1))) {
                break;
            }
        }
    }


}





