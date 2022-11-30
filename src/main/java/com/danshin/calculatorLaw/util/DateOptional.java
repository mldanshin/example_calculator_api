package com.danshin.calculatorLaw.util;

import java.time.LocalDate;

public class DateOptional {
    public static LocalDate orDefault(LocalDate date) {
        if (date == null) {
            return LocalDate.now();
        } else {
            return date;
        }
    }
}
