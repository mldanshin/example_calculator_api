package com.danshin.calculatorLaw.services.interfaces.police;

import com.danshin.calculatorLaw.models.dto.police.RankDto;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

public interface RankService {
    List<RankDto> getAll(@NotNull Integer postTypeId, @NotNull LocalDate date);

    RankDto getById(int id);
}
