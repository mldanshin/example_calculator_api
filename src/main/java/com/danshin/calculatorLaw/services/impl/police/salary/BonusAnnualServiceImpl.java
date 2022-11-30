package com.danshin.calculatorLaw.services.impl.police.salary;

import com.danshin.calculatorLaw.models.dto.police.salary.BonusAnnualDto;
import com.danshin.calculatorLaw.repositories.police.salary.BonusAnnualRepository;
import com.danshin.calculatorLaw.services.interfaces.police.salary.BonusAnnualService;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Service
public record BonusAnnualServiceImpl(BonusAnnualRepository repository) implements BonusAnnualService {
    @Override
    public List<BonusAnnualDto> getAll(@NotNull LocalDate date) {
        return repository.getAll(date);
    }

    @Override
    public List<BonusAnnualDto> getById(@NotNull List<Integer> id) {
        return repository.getById(id);
    }
}
