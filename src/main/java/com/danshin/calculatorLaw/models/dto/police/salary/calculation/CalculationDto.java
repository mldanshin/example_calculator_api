package com.danshin.calculatorLaw.models.dto.police.salary.calculation;

import com.danshin.calculatorLaw.models.dto.police.PostDto;
import com.danshin.calculatorLaw.models.dto.police.RankDto;
import com.danshin.calculatorLaw.models.dto.police.RegionalCoefficientDto;
import com.danshin.calculatorLaw.models.dto.police.salary.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Getter
public class CalculationDto {

    @NotNull
    private final CalculationItemFixedAmountDto<PostDto> post;

    @NotNull
    private final CalculationItemFixedAmountDto<RankDto> rank;

    @NotNull
    private final CalculationItemFixedPercentageDto<SeniorityDto> seniority;

    private CalculationItemFixedPercentageDto<QualificationRankDto> qualificationRank;

    private CalculationItemFloatingPercentageDto<StateSecretDto> stateSecret;

    private List<CalculationItemFloatingPercentageDto<SpecialConditionsDto>> specialConditions;

    private List<CalculationItemFixedPercentageDto<SpecialAchievementDto>> specialAchievement;

    private List<CalculationItemFixedPercentageDto<DangerDto>> danger;

    private List<CalculationItemFixedPercentageDto<BonusAnnualDto>> bonusAnnual;

    private CalculationItemFixedPercentageDto<PlaceServiceDto> placeService;

    @NotNull
    private final CalculationItemFloatingPercentageDto<RegionalCoefficientDto> regionalCoefficient;

    private List<CalculationItemFixedPercentageDto<BonusOneTimeDto>> bonusOneTime;

    private final BigDecimal postValue;

    private final BigDecimal rankValue;

    private final BigDecimal postRankValue;

    private BigDecimal deduction = new BigDecimal(0);

    private BigDecimal total = new BigDecimal(0);

    private BigDecimal result = new BigDecimal(0);

    public CalculationDto(@NotNull PostDto postDto,
                          @NotNull RankDto rankDto,
                          @NotNull SeniorityDto seniorityDto,
                          @NotNull RegionalCoefficientDto regionalCoefficientDto,
                          short regionalCoefficientValue
    ) {
        postValue = BigDecimal.valueOf(postDto.getSalary());
        this.post = new CalculationItemFixedAmountDto<>(postDto, postValue);

        rankValue = BigDecimal.valueOf(rankDto.getSalary());
        this.rank = new CalculationItemFixedAmountDto<>(rankDto, rankValue);

        postRankValue = postValue.add(rankValue);

        this.seniority = new CalculationItemFixedPercentageDto<>(
                seniorityDto,
                postRankValue.multiply(BigDecimal.valueOf(seniorityDto.getPercent() / 100))
        );

        this.regionalCoefficient = new CalculationItemFloatingPercentageDto<>(
                regionalCoefficientDto,
                postRankValue.multiply(BigDecimal.valueOf(regionalCoefficientValue / 100))
        );

        total = total.add(postRankValue);
    }

    public void setQualificationRank(@NotNull QualificationRankDto qualificationRankDto) {
        BigDecimal value = BigDecimal.valueOf(qualificationRankDto.getPercent() / 100);
        this.qualificationRank = new CalculationItemFixedPercentageDto<>(
                qualificationRankDto,
                value
                );

        total = total.add(value);
    }

    public void setStateSecret(StateSecretDto stateSecretDto, short stateSecretPercent) {
        BigDecimal value = BigDecimal.valueOf(stateSecretPercent / 100);
        this.stateSecret = new CalculationItemFloatingPercentageDto<>(
                stateSecretDto,
                value
        );

        total = total.add(value);
    }

    public void setSpecialConditions(List<CalculationItemFloatingPercentageDto<SpecialConditionsDto>> specialConditions) {
        this.specialConditions = specialConditions;
    }

    public void setSpecialAchievement(List<CalculationItemFixedPercentageDto<SpecialAchievementDto>> specialAchievement) {
        this.specialAchievement = specialAchievement;
    }

    public void setDanger(List<CalculationItemFixedPercentageDto<DangerDto>> danger) {
        this.danger = danger;
    }

    public void setBonusAnnual(List<CalculationItemFixedPercentageDto<BonusAnnualDto>> bonusAnnual) {
        this.bonusAnnual = bonusAnnual;
    }

    public void setPlaceService(CalculationItemFixedPercentageDto<PlaceServiceDto> placeService) {
        this.placeService = placeService;
    }

    public void setBonusOneTime(List<CalculationItemFixedPercentageDto<BonusOneTimeDto>> bonusOneTime) {
        this.bonusOneTime = bonusOneTime;
    }
}
