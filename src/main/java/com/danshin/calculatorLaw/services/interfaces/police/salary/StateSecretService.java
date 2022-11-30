package com.danshin.calculatorLaw.services.interfaces.police.salary;

import com.danshin.calculatorLaw.models.dto.police.salary.StateSecretDto;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

public interface StateSecretService {
    List<StateSecretDto> getAll(@NotNull LocalDate date);

    List<StateSecretDto> getById(@NotNull List<Integer> id);
}
