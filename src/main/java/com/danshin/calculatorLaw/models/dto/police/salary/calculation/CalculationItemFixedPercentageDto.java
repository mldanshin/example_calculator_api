package com.danshin.calculatorLaw.models.dto.police.salary.calculation;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class CalculationItemFixedPercentageDto<T> extends CalculationItemDto<T> {

    public CalculationItemFixedPercentageDto(@NotNull T description, @NotNull BigDecimal value) {
        super(description, value);
    }
}
