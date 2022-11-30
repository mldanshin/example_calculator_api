package com.danshin.calculatorLaw.repositories.police.salary;

import com.danshin.calculatorLaw.models.dto.police.salary.SpecialConditionsDto;
import com.danshin.calculatorLaw.models.police.salary.SpecialConditions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface SpecialConditionsRepository extends JpaRepository<SpecialConditions, Integer> {
    @Query("SELECT NEW com.danshin.calculatorLaw.models.dto.police.salary.SpecialConditionsDto(" +
            "s.id," +
            "s.name," +
            "s.nameShort," +
            "s.percentMin," +
            "s.percentMax" +
            ") " +
            "FROM SpecialConditions s " +
            "WHERE s.dateStart <= :date AND (s.dateEnd IS NULL OR :date <= s.dateEnd)")
    List<SpecialConditionsDto> getAll(@NotNull @Param("date") LocalDate date);

    @Query("SELECT NEW com.danshin.calculatorLaw.models.dto.police.salary.SpecialConditionsDto(" +
            "s.id," +
            "s.name," +
            "s.nameShort," +
            "s.percentMin," +
            "s.percentMax" +
            ") " +
            "FROM SpecialConditions s " +
            "WHERE s.id IN (:id)")
    List<SpecialConditionsDto> getById(@NotNull @Param("id") List<Integer> id);
}
