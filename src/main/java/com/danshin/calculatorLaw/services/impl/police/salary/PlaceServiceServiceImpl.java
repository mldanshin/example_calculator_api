package com.danshin.calculatorLaw.services.impl.police.salary;

import com.danshin.calculatorLaw.models.dto.police.salary.PlaceServiceDto;
import com.danshin.calculatorLaw.repositories.police.salary.PlaceServiceRepository;
import com.danshin.calculatorLaw.services.interfaces.police.salary.PlaceServiceService;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Service
public record PlaceServiceServiceImpl(PlaceServiceRepository repository) implements PlaceServiceService {
    @Override
    public List<PlaceServiceDto> getAll(@NotNull LocalDate date) {
        return repository.getAll(date);
    }

    @Override
    public List<PlaceServiceDto> getById(List<Integer> id) {
        return repository.getById(id);
    }
}
