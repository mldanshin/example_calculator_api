package com.danshin.calculatorLaw.models.dto.police.salary.calculation;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class CalculationItemFixedAmountDto<T> extends CalculationItemDto<T> {

    public CalculationItemFixedAmountDto(@NotNull T description, @NotNull BigDecimal value) {
        super(description, value);
    }
}
