package com.danshin.calculatorLaw.services.interfaces.police.salary;

import com.danshin.calculatorLaw.models.dto.police.salary.QualificationRankDto;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

public interface QualificationRankService {
    List<QualificationRankDto> getAll(@NotNull LocalDate date);

    QualificationRankDto getById(int id);
}
