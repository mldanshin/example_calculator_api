package com.danshin.calculatorLaw.repositories.police;

import com.danshin.calculatorLaw.models.dto.police.PostDto;
import org.springframework.data.repository.query.Param;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

public interface PostRepositoryCustom {
    List<PostDto> getAll(
            @NotNull Integer governmentId,
            @NotNull Integer typeId,
            @NotNull @Param("date") LocalDate date
    );

    PostDto getById(int id);
}
