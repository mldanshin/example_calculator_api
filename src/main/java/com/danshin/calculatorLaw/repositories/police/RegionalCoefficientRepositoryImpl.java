package com.danshin.calculatorLaw.repositories.police;

import com.danshin.calculatorLaw.models.dto.police.RegionalCoefficientDto;
import com.danshin.calculatorLaw.models.police.Label;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class RegionalCoefficientRepositoryImpl implements RegionalCoefficientRepository {
    private Label label;

    public RegionalCoefficientDto get() {
        return new RegionalCoefficientDto(
                label.getRegionalCoefficient(),
                (short) 0,
                (short) 100
        );
    }
}
