package com.danshin.calculatorLaw.models.dto.police;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@Getter
public class RankDto {
    private int id;
    @NotNull
    private String name;
    private int salary;
}
