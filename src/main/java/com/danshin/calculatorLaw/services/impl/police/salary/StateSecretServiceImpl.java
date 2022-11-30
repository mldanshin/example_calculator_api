package com.danshin.calculatorLaw.services.impl.police.salary;

import com.danshin.calculatorLaw.models.dto.police.salary.StateSecretDto;
import com.danshin.calculatorLaw.repositories.police.salary.StateSecretRepository;
import com.danshin.calculatorLaw.services.interfaces.police.salary.StateSecretService;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Service
public record StateSecretServiceImpl(StateSecretRepository repository) implements StateSecretService {
    @Override
    public List<StateSecretDto> getAll(@NotNull LocalDate date) {
        return repository.getAll(date);
    }

    @Override
    public List<StateSecretDto> getById(List<Integer> id) {
        return repository.getById(id);
    }
}
