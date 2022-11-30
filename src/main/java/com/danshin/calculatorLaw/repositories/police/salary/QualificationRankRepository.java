package com.danshin.calculatorLaw.repositories.police.salary;

import com.danshin.calculatorLaw.models.dto.police.salary.QualificationRankDto;
import com.danshin.calculatorLaw.models.police.salary.QualificationRank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface QualificationRankRepository extends JpaRepository<QualificationRank, Integer> {
    @Query("SELECT NEW com.danshin.calculatorLaw.models.dto.police.salary.QualificationRankDto(" +
            "q.id," +
            "q.name," +
            "q.percent" +
            ") " +
            "FROM QualificationRank q " +
            "WHERE q.dateStart <= :date AND (q.dateEnd IS NULL OR :date <= q.dateEnd)")
    List<QualificationRankDto> getAll(@NotNull @Param("date") LocalDate date);

    @Query("SELECT NEW com.danshin.calculatorLaw.models.dto.police.salary.QualificationRankDto(" +
            "q.id," +
            "q.name," +
            "q.percent" +
            ") " +
            "FROM QualificationRank q " +
            "WHERE q.id = :id")
    QualificationRankDto getById(@Param("id") int id);
}
