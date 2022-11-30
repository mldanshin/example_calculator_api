package com.danshin.calculatorLaw.services.impl.police;

import com.danshin.calculatorLaw.models.dto.police.RankDto;
import com.danshin.calculatorLaw.repositories.police.RankRepository;
import com.danshin.calculatorLaw.services.interfaces.police.RankService;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Service
public record RankServiceImpl(RankRepository repository) implements RankService {
    @Override
    public List<RankDto> getAll(@NotNull Integer postTypeId, @NotNull LocalDate date) {
        return repository.getAll(postTypeId, date);
    }

    @Override
    public RankDto getById(int id) {
        return repository.getById(id);
    }
}
