package com.danshin.calculatorLaw.repositories.police;

import com.danshin.calculatorLaw.models.dto.police.PostTypeDto;
import com.danshin.calculatorLaw.models.police.PostType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface PostTypeRepository extends JpaRepository<PostType, Integer> {
    @Query("SELECT NEW com.danshin.calculatorLaw.models.dto.police.PostTypeDto(" +
            "pt.id," +
            "pt.name" +
            ") " +
            "FROM PostType pt " +
            "WHERE pt.dateStart <= :date AND (pt.dateEnd IS NULL OR :date <= pt.dateEnd)")
    List<PostTypeDto> getAll(@NotNull @Param("date") LocalDate date);
}
