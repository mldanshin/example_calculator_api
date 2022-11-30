package com.danshin.calculatorLaw.repositories.police.salary;

import com.danshin.calculatorLaw.models.dto.police.salary.BonusOneTimeDto;
import com.danshin.calculatorLaw.models.police.salary.BonusOneTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface BonusOneTimeRepository extends JpaRepository<BonusOneTime, Integer> {
    @Query("SELECT NEW com.danshin.calculatorLaw.models.dto.police.salary.BonusOneTimeDto(" +
            "b.id," +
            "b.name," +
            "b.nameShort," +
            "b.percent" +
            ") " +
            "FROM BonusOneTime b " +
            "WHERE b.dateStart <= :date AND (b.dateEnd IS NULL OR :date <= b.dateEnd)")
    List<BonusOneTimeDto> getAll(@NotNull @Param("date") LocalDate date);

    @Query("SELECT NEW com.danshin.calculatorLaw.models.dto.police.salary.BonusOneTimeDto(" +
            "b.id," +
            "b.name," +
            "b.nameShort," +
            "b.percent" +
            ") " +
            "FROM BonusOneTime b " +
            "WHERE b.id IN (:id)")
    List<BonusOneTimeDto> getById(@NotNull @Param("id") List<Integer> id);
}
