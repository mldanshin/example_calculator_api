package com.danshin.calculatorLaw.repositories.police;

import com.danshin.calculatorLaw.models.dto.police.RankDto;
import org.springframework.data.repository.query.Param;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

public interface RankRepositoryCustom {
    List<RankDto> getAll(
            @NotNull Integer postTypeId,
            @NotNull @Param("date") LocalDate date
    );

    RankDto getById(int id);
}
