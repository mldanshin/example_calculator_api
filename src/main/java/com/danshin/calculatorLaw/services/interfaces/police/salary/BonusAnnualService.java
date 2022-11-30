package com.danshin.calculatorLaw.services.interfaces.police.salary;

import com.danshin.calculatorLaw.models.dto.police.salary.BonusAnnualDto;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

public interface BonusAnnualService {
    List<BonusAnnualDto> getAll(@NotNull LocalDate date);

    List<BonusAnnualDto> getById(@NotNull List<Integer> id);
}
