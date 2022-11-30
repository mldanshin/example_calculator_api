package com.danshin.calculatorLaw.models.dto.police.salary;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SpecialAchievementDto {
    private int id;
    private String name;
    private String nameShort;
    private short percent;
}
