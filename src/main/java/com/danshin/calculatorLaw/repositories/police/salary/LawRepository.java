package com.danshin.calculatorLaw.repositories.police.salary;

import com.danshin.calculatorLaw.models.dto.police.salary.LawDto;
import com.danshin.calculatorLaw.models.police.salary.LawPS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface LawRepository extends JpaRepository<LawPS, Integer> {
    @Query("SELECT NEW com.danshin.calculatorLaw.models.dto.police.salary.LawDto(" +
            "lt.name," +
            "lt.importance," +
            "l.number," +
            "l.name" +
            ") " +
            "FROM LawPS lps " +
            "join lps.law l " +
            "join l.lawType lt " +
            "WHERE l.dateStart <= :date AND (l.dateEnd IS NULL OR :date <= l.dateEnd)")
    List<LawDto> getAll(@NotNull @Param("date") LocalDate date);
}
