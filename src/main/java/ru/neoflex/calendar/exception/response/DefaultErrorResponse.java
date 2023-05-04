package ru.neoflex.calendar.exception.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class DefaultErrorResponse {
    private final String info;
    private final Throwable cause;
}
