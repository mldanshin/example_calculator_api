package com.danshin.calculatorLaw.services.interfaces.police.salary;

import com.danshin.calculatorLaw.models.dto.police.salary.LawDto;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

public interface LawService {
    List<LawDto> getAll(@NotNull LocalDate date);
}
