package com.danshin.calculatorLaw.services.impl.police;

import com.danshin.calculatorLaw.models.dto.police.RegionalCoefficientDto;
import com.danshin.calculatorLaw.repositories.police.RegionalCoefficientRepository;
import com.danshin.calculatorLaw.services.interfaces.police.RegionalCoefficientService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record RegionalCoefficientServiceImpl(
        RegionalCoefficientRepository repository) implements RegionalCoefficientService {
    @Override
    public RegionalCoefficientDto get() {
        return repository.get();
    }
}
