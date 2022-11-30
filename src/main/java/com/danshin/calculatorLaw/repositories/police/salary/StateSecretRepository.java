package com.danshin.calculatorLaw.repositories.police.salary;

import com.danshin.calculatorLaw.models.dto.police.salary.StateSecretDto;
import com.danshin.calculatorLaw.models.police.salary.StateSecret;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface StateSecretRepository extends JpaRepository<StateSecret, Integer> {
    @Query("SELECT NEW com.danshin.calculatorLaw.models.dto.police.salary.StateSecretDto(" +
            "s.id," +
            "s.name," +
            "s.percentMin," +
            "s.percentMax" +
            ") " +
            "FROM StateSecret s " +
            "WHERE s.dateStart <= :date AND (s.dateEnd IS NULL OR :date <= s.dateEnd)")
    List<StateSecretDto> getAll(@NotNull @Param("date") LocalDate date);

    @Query("SELECT NEW com.danshin.calculatorLaw.models.dto.police.salary.StateSecretDto(" +
            "s.id," +
            "s.name," +
            "s.percentMin," +
            "s.percentMax" +
            ") " +
            "FROM StateSecret s " +
            "WHERE s.id IN (:id)")
    List<StateSecretDto> getById(@NotNull @Param("id") List<Integer> id);
}
