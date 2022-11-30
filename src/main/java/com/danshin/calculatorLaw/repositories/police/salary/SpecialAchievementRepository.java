package com.danshin.calculatorLaw.repositories.police.salary;

import com.danshin.calculatorLaw.models.dto.police.salary.SpecialAchievementDto;
import com.danshin.calculatorLaw.models.police.salary.SpecialAchievement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface SpecialAchievementRepository extends JpaRepository<SpecialAchievement, Integer> {
    @Query("SELECT NEW com.danshin.calculatorLaw.models.dto.police.salary.SpecialAchievementDto(" +
            "s.id," +
            "s.name," +
            "s.nameShort," +
            "s.percent" +
            ") " +
            "FROM SpecialAchievement s " +
            "WHERE s.dateStart <= :date AND (s.dateEnd IS NULL OR :date <= s.dateEnd)")
    List<SpecialAchievementDto> getAll(@NotNull @Param("date") LocalDate date);

    @Query("SELECT NEW com.danshin.calculatorLaw.models.dto.police.salary.SpecialAchievementDto(" +
            "s.id," +
            "s.name," +
            "s.nameShort," +
            "s.percent" +
            ") " +
            "FROM SpecialAchievement s " +
            "WHERE s.id IN (:id)")
    List<SpecialAchievementDto> getById(@NotNull @Param("id") List<Integer> id);
}
