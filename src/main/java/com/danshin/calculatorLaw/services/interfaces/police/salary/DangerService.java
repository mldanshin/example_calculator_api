package com.danshin.calculatorLaw.services.interfaces.police.salary;

import com.danshin.calculatorLaw.models.dto.police.salary.DangerDto;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

public interface DangerService {
    List<DangerDto> getAll(@NotNull LocalDate date);

    List<DangerDto> getById(@NotNull List<Integer> id);
}
