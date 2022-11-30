package com.danshin.calculatorLaw.services.impl.police;

import com.danshin.calculatorLaw.models.dto.police.PostTypeDto;
import com.danshin.calculatorLaw.repositories.police.PostTypeRepository;
import com.danshin.calculatorLaw.services.interfaces.police.PostTypeService;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Service
public record PostTypeServiceImpl(PostTypeRepository repository) implements PostTypeService {
    @Override
    public List<PostTypeDto> getAll(@NotNull LocalDate date) {
        return repository.getAll(date);
    }
}
