package com.danshin.calculatorLaw.models.dto.police;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@Getter
public class RegionalCoefficientDto {
    @NotNull
    private String name;
    private short percentMin;
    private short percentMax;
}
