package com.danshin.calculatorLaw.models.dto.police.salary.calculation;

import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
public class CalculationItemFloatingPercentageDto<T> extends CalculationItemDto<T> {

    private short currentPercent;

    public CalculationItemFloatingPercentageDto(@NotNull T description, @NotNull BigDecimal value) {
        super(description, value);
    }
}
