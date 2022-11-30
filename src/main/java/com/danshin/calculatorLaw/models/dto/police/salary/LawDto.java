package com.danshin.calculatorLaw.models.dto.police.salary;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class LawDto {
    private String type;
    private short importance;
    private short number;
    private String name;
}
