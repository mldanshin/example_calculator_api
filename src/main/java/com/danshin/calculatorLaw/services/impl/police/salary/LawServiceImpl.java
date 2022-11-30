package com.danshin.calculatorLaw.services.impl.police.salary;

import com.danshin.calculatorLaw.models.dto.police.salary.LawDto;
import com.danshin.calculatorLaw.repositories.police.salary.LawRepository;
import com.danshin.calculatorLaw.services.interfaces.police.salary.LawService;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Service
public record LawServiceImpl(LawRepository repository) implements LawService {
    @Override
    public List<LawDto> getAll(@NotNull LocalDate date) {
        return repository.getAll(date);
    }
}
