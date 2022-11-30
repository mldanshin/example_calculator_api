package com.danshin.calculatorLaw.services.impl.police.salary;

import com.danshin.calculatorLaw.models.dto.police.salary.SpecialAchievementDto;
import com.danshin.calculatorLaw.repositories.police.salary.SpecialAchievementRepository;
import com.danshin.calculatorLaw.services.interfaces.police.salary.SpecialAchievementService;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Service
public record SpecialAchievementServiceImpl(
        SpecialAchievementRepository repository) implements SpecialAchievementService {
    @Override
    public List<SpecialAchievementDto> getAll(@NotNull LocalDate date) {
        return repository.getAll(date);
    }

    @Override
    public List<SpecialAchievementDto> getById(List<Integer> id) {
        return repository.getById(id);
    }
}
