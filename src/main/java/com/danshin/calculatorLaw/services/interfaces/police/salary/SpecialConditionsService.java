package com.danshin.calculatorLaw.services.interfaces.police.salary;

import com.danshin.calculatorLaw.models.dto.police.salary.SpecialConditionsDto;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

public interface SpecialConditionsService {
    List<SpecialConditionsDto> getAll(@NotNull LocalDate date);

    List<SpecialConditionsDto> getById(@NotNull List<Integer> id);
}
