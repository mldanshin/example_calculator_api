package com.danshin.calculatorLaw.repositories.police.salary;

import com.danshin.calculatorLaw.models.dto.police.salary.DangerDto;
import com.danshin.calculatorLaw.models.police.salary.Danger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface DangerRepository extends JpaRepository<Danger, Integer> {
    @Query("SELECT NEW com.danshin.calculatorLaw.models.dto.police.salary.DangerDto(" +
            "d.id," +
            "d.name," +
            "d.nameShort," +
            "d.percent" +
            ") " +
            "FROM Danger d " +
            "WHERE d.dateStart <= :date AND (d.dateEnd IS NULL OR :date <= d.dateEnd)")
    List<DangerDto> getAll(@NotNull @Param("date") LocalDate date);

    @Query("SELECT NEW com.danshin.calculatorLaw.models.dto.police.salary.DangerDto(" +
            "d.id," +
            "d.name," +
            "d.nameShort," +
            "d.percent" +
            ") " +
            "FROM Danger d " +
            "WHERE d.id IN (:id)")
    List<DangerDto> getById(@NotNull @Param("id") List<Integer> id);
}
