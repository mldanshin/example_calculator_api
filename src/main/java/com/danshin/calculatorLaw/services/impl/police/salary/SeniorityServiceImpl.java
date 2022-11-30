package com.danshin.calculatorLaw.services.impl.police.salary;

import com.danshin.calculatorLaw.models.dto.police.salary.SeniorityDto;
import com.danshin.calculatorLaw.repositories.police.salary.SeniorityRepository;
import com.danshin.calculatorLaw.services.interfaces.police.salary.SeniorityService;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Service
public record SeniorityServiceImpl(SeniorityRepository repository) implements SeniorityService {
    @Override
    public List<SeniorityDto> getAll(@NotNull LocalDate date) {
        return repository.getAll(date);
    }

    @Override
    public SeniorityDto getById(int id) {
        return repository.getById(id);
    }
}
