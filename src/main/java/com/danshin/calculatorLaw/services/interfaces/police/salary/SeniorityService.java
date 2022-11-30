package com.danshin.calculatorLaw.services.interfaces.police.salary;

import com.danshin.calculatorLaw.models.dto.police.salary.SeniorityDto;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

public interface SeniorityService {
    List<SeniorityDto> getAll(@NotNull LocalDate date);

    SeniorityDto getById(int id);
}
