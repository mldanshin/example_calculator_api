package com.danshin.calculatorLaw.repositories.police.salary;

import com.danshin.calculatorLaw.models.dto.police.salary.SeniorityDto;
import com.danshin.calculatorLaw.models.police.salary.Seniority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface SeniorityRepository extends JpaRepository<Seniority, Integer> {
    @Query("SELECT NEW com.danshin.calculatorLaw.models.dto.police.salary.SeniorityDto(" +
            "s.id," +
            "s.name," +
            "s.percent" +
            ") " +
            "FROM Seniority s " +
            "WHERE s.dateStart <= :date AND (s.dateEnd IS NULL OR :date <= s.dateEnd)")
    List<SeniorityDto> getAll(@NotNull @Param("date") LocalDate date);

    @Query("SELECT NEW com.danshin.calculatorLaw.models.dto.police.salary.SeniorityDto(" +
            "s.id," +
            "s.name," +
            "s.percent" +
            ") " +
            "FROM Seniority s " +
            "WHERE s.id = :id")
    SeniorityDto getById(@Param("id") int id);
}
