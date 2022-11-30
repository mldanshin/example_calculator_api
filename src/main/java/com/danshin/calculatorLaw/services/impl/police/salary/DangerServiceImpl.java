package com.danshin.calculatorLaw.services.impl.police.salary;

import com.danshin.calculatorLaw.models.dto.police.salary.DangerDto;
import com.danshin.calculatorLaw.repositories.police.salary.DangerRepository;
import com.danshin.calculatorLaw.services.interfaces.police.salary.DangerService;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Service
public record DangerServiceImpl(DangerRepository repository) implements DangerService {
    @Override
    public List<DangerDto> getAll(@NotNull LocalDate date) {
        return repository.getAll(date);
    }

    @Override
    public List<DangerDto> getById(List<Integer> id) {
        return repository.getById(id);
    }
}
