package com.danshin.calculatorLaw.services.impl.police.salary;

import com.danshin.calculatorLaw.models.dto.police.salary.SpecialConditionsDto;
import com.danshin.calculatorLaw.repositories.police.salary.SpecialConditionsRepository;
import com.danshin.calculatorLaw.services.interfaces.police.salary.SpecialConditionsService;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Service
public record SpecialConditionsServiceImpl(SpecialConditionsRepository repository) implements SpecialConditionsService {
    @Override
    public List<SpecialConditionsDto> getAll(@NotNull LocalDate date) {
        return repository.getAll(date);
    }

    @Override
    public List<SpecialConditionsDto> getById(List<Integer> id) {
        return repository.getById(id);
    }
}
