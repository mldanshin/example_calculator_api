package com.danshin.calculatorLaw.services.impl.police;

import com.danshin.calculatorLaw.models.dto.police.GovernmentDto;
import com.danshin.calculatorLaw.repositories.police.GovernmentRepository;
import com.danshin.calculatorLaw.services.interfaces.police.GovernmentService;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Service
public record GovernmentServiceImpl(GovernmentRepository repository) implements GovernmentService {
    @Override
    public List<GovernmentDto> getAll(@NotNull LocalDate date) {
        return repository.getAll(date);
    }
}
