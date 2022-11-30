package com.danshin.calculatorLaw.services.interfaces.police;

import com.danshin.calculatorLaw.models.dto.police.GovernmentDto;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

public interface GovernmentService {
    List<GovernmentDto> getAll(@NotNull LocalDate date);
}
