package com.danshin.calculatorLaw.repositories.police;

import com.danshin.calculatorLaw.models.dto.police.GovernmentDto;
import com.danshin.calculatorLaw.models.police.Government;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface GovernmentRepository extends JpaRepository<Government, Integer> {
    @Query("SELECT NEW com.danshin.calculatorLaw.models.dto.police.GovernmentDto(" +
            "g.id," +
            "g.name," +
            "g.nameShort" +
            ") " +
            "FROM Government g " +
            "WHERE g.dateStart <= :date AND (g.dateEnd IS NULL OR :date <= g.dateEnd)")
    List<GovernmentDto> getAll(@NotNull @Param("date") LocalDate date);
}
