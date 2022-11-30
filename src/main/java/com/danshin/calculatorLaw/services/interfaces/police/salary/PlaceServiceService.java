package com.danshin.calculatorLaw.services.interfaces.police.salary;

import com.danshin.calculatorLaw.models.dto.police.salary.PlaceServiceDto;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

public interface PlaceServiceService {
    List<PlaceServiceDto> getAll(@NotNull LocalDate date);

    List<PlaceServiceDto> getById(@NotNull List<Integer> id);
}
