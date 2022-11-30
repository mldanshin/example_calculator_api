package com.danshin.calculatorLaw.models.dto.police.salary;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SpecialConditionsDto {
    private int id;
    private String name;
    private String nameShort;
    private short percentMin;
    private short percentMax;
}
