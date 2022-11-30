package com.danshin.calculatorLaw.services.impl.police.salary;

import com.danshin.calculatorLaw.models.dto.police.salary.QualificationRankDto;
import com.danshin.calculatorLaw.repositories.police.salary.QualificationRankRepository;
import com.danshin.calculatorLaw.services.interfaces.police.salary.QualificationRankService;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Service
public record QualificationRankServiceImpl(QualificationRankRepository repository) implements QualificationRankService {
    @Override
    public List<QualificationRankDto> getAll(@NotNull LocalDate date) {
        return repository.getAll(date);
    }

    @Override
    public QualificationRankDto getById(int id) {
        return repository.getById(id);
    }
}
