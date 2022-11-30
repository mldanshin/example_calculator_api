package com.danshin.calculatorLaw.services.interfaces.police.salary;

import com.danshin.calculatorLaw.models.dto.police.salary.SpecialAchievementDto;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

public interface SpecialAchievementService {
    List<SpecialAchievementDto> getAll(@NotNull LocalDate date);

    List<SpecialAchievementDto> getById(@NotNull List<Integer> id);
}
