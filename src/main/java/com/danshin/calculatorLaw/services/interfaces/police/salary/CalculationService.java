package com.danshin.calculatorLaw.services.interfaces.police.salary;

import com.danshin.calculatorLaw.exceptions.BadRequestException;
import com.danshin.calculatorLaw.models.dto.police.salary.calculation.CalculationDto;
import com.danshin.calculatorLaw.requests.police.salary.CalculationRequestDto;

public interface CalculationService {
    CalculationDto getCalculation(CalculationRequestDto request) throws BadRequestException;
}
