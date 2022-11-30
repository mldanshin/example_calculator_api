package com.danshin.calculatorLaw.models.dto.police.salary.calculation;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public abstract class CalculationItemDto<T> {

    @NotNull
    private T description;

    @NotNull
    private BigDecimal value;
}
