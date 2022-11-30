package com.danshin.calculatorLaw.services.impl.police.salary;

import com.danshin.calculatorLaw.models.dto.police.salary.BonusOneTimeDto;
import com.danshin.calculatorLaw.repositories.police.salary.BonusOneTimeRepository;
import com.danshin.calculatorLaw.services.interfaces.police.salary.BonusOneTimeService;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Service
public record BonusOneTimeServiceImpl(BonusOneTimeRepository repository) implements BonusOneTimeService {
    @Override
    public List<BonusOneTimeDto> getAll(@NotNull LocalDate date) {
        return repository.getAll(date);
    }

    @Override
    public List<BonusOneTimeDto> getById(@NotNull List<Integer> id) {
        return repository.getById(id);
    }
}
