package com.danshin.calculatorLaw.services.interfaces.police;

import com.danshin.calculatorLaw.models.dto.police.PostDto;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

public interface PostService {
    List<PostDto> getAll(@NotNull Integer governmentId, @NotNull Integer typeId, @NotNull LocalDate date);

    PostDto getById(int id);
}
