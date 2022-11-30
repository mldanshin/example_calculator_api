package com.danshin.calculatorLaw.models.dto.police.salary;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class StateSecretDto {
    private int id;
    private String name;
    private short percentMin;
    private short percentMax;
}
