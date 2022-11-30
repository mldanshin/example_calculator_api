package com.danshin.calculatorLaw.services.impl.police.salary;

import com.danshin.calculatorLaw.exceptions.BadRequestException;
import com.danshin.calculatorLaw.models.dto.police.PostDto;
import com.danshin.calculatorLaw.models.dto.police.RankDto;
import com.danshin.calculatorLaw.models.dto.police.RegionalCoefficientDto;
import com.danshin.calculatorLaw.models.dto.police.salary.QualificationRankDto;
import com.danshin.calculatorLaw.models.dto.police.salary.SeniorityDto;
import com.danshin.calculatorLaw.models.dto.police.salary.StateSecretDto;
import com.danshin.calculatorLaw.models.dto.police.salary.calculation.CalculationDto;
import com.danshin.calculatorLaw.models.dto.police.salary.calculation.CalculationItemFixedAmountDto;
import com.danshin.calculatorLaw.models.dto.police.salary.calculation.CalculationItemFixedPercentageDto;
import com.danshin.calculatorLaw.models.dto.police.salary.calculation.CalculationItemFloatingPercentageDto;
import com.danshin.calculatorLaw.models.police.salary.QualificationRank;
import com.danshin.calculatorLaw.requests.police.salary.CalculationRequestDto;
import com.danshin.calculatorLaw.services.interfaces.police.PostService;
import com.danshin.calculatorLaw.services.interfaces.police.RankService;
import com.danshin.calculatorLaw.services.interfaces.police.RegionalCoefficientService;
import com.danshin.calculatorLaw.services.interfaces.police.salary.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class CalculationServiceImpl implements CalculationService {

    private final PostService postService;
    private final RankService rankService;
    private final SeniorityService seniorityService;
    private final QualificationRankService qualificationRankService;
    private final StateSecretService stateSecretService;
    private final SpecialConditionsService specialConditionsService;
    private final SpecialAchievementService specialAchievementService;
    private final DangerService dangerService;
    private final BonusAnnualService bonusAnnualService;
    private final PlaceServiceService placeServiceService;
    private final RegionalCoefficientService regionalCoefficientService;
    private final BonusOneTimeService bonusOneTimeService;

    public CalculationServiceImpl(PostService postService, RankService rankService, SeniorityService seniorityService, QualificationRankService qualificationRankService, StateSecretService stateSecretService, SpecialConditionsService specialConditionsService, SpecialAchievementService specialAchievementService, DangerService dangerService, BonusAnnualService bonusAnnualService, PlaceServiceService placeServiceService, RegionalCoefficientService regionalCoefficientService, BonusOneTimeService bonusOneTimeService) {
        this.postService = postService;
        this.rankService = rankService;
        this.seniorityService = seniorityService;
        this.qualificationRankService = qualificationRankService;
        this.stateSecretService = stateSecretService;
        this.specialConditionsService = specialConditionsService;
        this.specialAchievementService = specialAchievementService;
        this.dangerService = dangerService;
        this.bonusAnnualService = bonusAnnualService;
        this.placeServiceService = placeServiceService;
        this.regionalCoefficientService = regionalCoefficientService;
        this.bonusOneTimeService = bonusOneTimeService;
    }

    @Transactional
    @Override
    public CalculationDto getCalculation(CalculationRequestDto request) throws BadRequestException {
        PostDto postDto = postService.getById(request.getPost());
        if (postDto == null) {
            throw new BadRequestException();
        }

        RankDto rankDto = rankService.getById(request.getRank());
        if (rankDto == null) {
            throw new BadRequestException();
        }

        SeniorityDto seniorityDto = seniorityService.getById(request.getSeniority());
        if (seniorityDto == null) {
            throw new BadRequestException();
        }

        RegionalCoefficientDto regionalCoefficientDto = regionalCoefficientService.get();
        if (regionalCoefficientDto == null) {
            throw new BadRequestException();
        }

        CalculationDto calculationDto = new CalculationDto(
                postDto,
                rankDto,
                seniorityDto,
                regionalCoefficientDto,
                request.getRegionalCoefficient()
        );

        if (request.getQualificationRank() != null) {
            QualificationRankDto qualificationRankDto = qualificationRankService.getById(request.getQualificationRank());
            if (qualificationRankDto == null) {
                throw new BadRequestException();
            }
            calculationDto.setQualificationRank(qualificationRankDto);
        }

        return calculationDto;
    }
}
