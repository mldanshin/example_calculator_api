package com.danshin.calculatorLaw.requests.police.salary;

import com.danshin.calculatorLaw.models.Pair;
import lombok.Builder;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.time.LocalDate;
import java.util.List;

@Builder
@Getter
public class CalculationRequestDto {
    @Null
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate date;

    @NotNull
    private Integer post;

    @NotNull
    private Integer rank;

    @NotNull
    private Integer seniority;

    private Integer qualificationRank;

    private Pair stateSecret;

    private List<Pair> specialConditions;

    private List<Integer> specialAchievement;

    private List<Integer> danger;

    private List<Integer> bonusAnnual;

    private List<Integer> placeService;

    @NotNull
    Short regionalCoefficient;

    List<Integer> bonusOneTime;
}
