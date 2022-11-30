package com.danshin.calculatorLaw.services.interfaces.police.salary;

import com.danshin.calculatorLaw.models.dto.police.salary.BonusOneTimeDto;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

public interface BonusOneTimeService {
    List<BonusOneTimeDto> getAll(@NotNull LocalDate date);

    List<BonusOneTimeDto> getById(@NotNull List<Integer> id);
}
