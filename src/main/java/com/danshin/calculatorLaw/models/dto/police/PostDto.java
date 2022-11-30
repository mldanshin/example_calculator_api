package com.danshin.calculatorLaw.models.dto.police;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PostDto {
    private int id;
    private String name;
    private String nameShort;
    private int salary;
}
