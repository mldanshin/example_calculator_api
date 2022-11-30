package com.danshin.calculatorLaw.services.impl.police;

import com.danshin.calculatorLaw.models.dto.police.PostDto;
import com.danshin.calculatorLaw.repositories.police.PostRepository;
import com.danshin.calculatorLaw.services.interfaces.police.PostService;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Service
public record PostServiceImpl(PostRepository repository) implements PostService {
    @Override
    public List<PostDto> getAll(@NotNull Integer governmentId, @NotNull Integer typeId, @NotNull LocalDate date) {
        return repository.getAll(governmentId, typeId, date);
    }

    @Override
    public PostDto getById(int id) {
        return repository.getById(id);
    }
}
