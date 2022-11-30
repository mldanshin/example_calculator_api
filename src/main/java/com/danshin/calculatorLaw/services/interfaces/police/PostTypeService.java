package com.danshin.calculatorLaw.services.interfaces.police;

import com.danshin.calculatorLaw.models.dto.police.PostTypeDto;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

public interface PostTypeService {
    List<PostTypeDto> getAll(@NotNull LocalDate date);
}
